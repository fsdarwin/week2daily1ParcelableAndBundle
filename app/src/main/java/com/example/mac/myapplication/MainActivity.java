package com.example.mac.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //VARIABLES----------------------------------------------------------------------------
    public static final String TAG = "HERE_FRANK:";
    public static final int RESULT_CODE = 666;
    TextView tvYear, tvMake, tvModel, tvColor, tvEngine, tvTransmissionType, tvTitleStatus;
    Button btnParc, btnSerl;
    SharedPreferences sharedPreferences;
    //-------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSTANCIATE VIEWS and BUTTONS
        tvYear = findViewById(R.id.tvYear);
        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModel);
        tvColor = findViewById(R.id.tvColor);
        tvEngine = findViewById(R.id.tvEngine);
        tvTransmissionType = findViewById(R.id.tvTransmissionType);
        tvTitleStatus = findViewById(R.id.tvTitleStatus);
        btnParc = findViewById(R.id.btnParc);
        btnSerl = findViewById(R.id.btnBund);

        //For PASSED BUNDLE----------------------------------------

        Intent intentPassed = getIntent();
        if (intentPassed.getExtras() != null) {//Check the intent is not null
            Bundle passedBundle = intentPassed.getExtras();// pull the bundle from the imtent
            tvYear.setText(passedBundle.get("year").toString());    //Set the TextView fields//
            tvMake.setText(passedBundle.get("make").toString());
            tvModel.setText(passedBundle.get("model").toString());
            tvColor.setText(passedBundle.get("color").toString());
            tvEngine.setText(passedBundle.get("engine").toString());
            tvTransmissionType.setText(passedBundle.get("transmissionType").toString());
            tvTitleStatus.setText(passedBundle.get("titleStatus").toString());
        }
        //----------------------------------------------------------


        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String savedFromPrefString = sharedPreferences.getString("Make", "NO VALUE");
        Log.d(TAG, savedFromPrefString);
        savedFromPrefString = sharedPreferences.getString("Model", "NO VALUE");
        Log.d(TAG, savedFromPrefString);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {//Check for null data
            Intent passedIntent = data;//Make new intent for data
            Car car = passedIntent.getParcelableExtra("car");//Pull out Car object from Intent
            tvYear.setText(car.getYear());    //Set the TextView fields
            tvMake.setText(car.getMake());
            tvModel.setText(car.getModel());
            tvColor.setText(car.getColor());
            tvEngine.setText(car.getEngine());
            tvTransmissionType.setText(car.getTransmissionType());
            tvTitleStatus.setText(car.getTitleStatus());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnParc://If the parcelable button is clicked
                Intent intentParc = new Intent(this, ActivityParcelable.class);
                startActivityForResult(intentParc, RESULT_CODE);//set for result and sent to ActivityParcelable
                break;
            case R.id.btnBund://if the Bundle button is clicked
                Intent intentBund = new Intent(this, ActivityBundle.class);
                startActivity(intentBund);//send to ActivityBundle
                break;
        }
    }
}
