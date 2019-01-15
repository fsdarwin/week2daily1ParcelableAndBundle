package com.example.mac.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityParcelable extends AppCompatActivity {

    //VARIABLES---------------------------------------------
    EditText evYear, evMake, evModel, evColor,
                evEngine, evTransmissionType, evTitleStatus;

    public static final String TAG = "HERE_FRANK:";
    public static final int RESULT_CODE = 666;

    SharedPreferences sharedPreferences;
    // ------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        //INSTANCIATE VIEWS----------------------------------------
        evYear = findViewById(R.id.evYear);
        evMake = findViewById(R.id.evMake);
        evModel = findViewById(R.id.evModel);
        evColor = findViewById(R.id.evColor);
        evEngine = findViewById(R.id.evEngine);
        evTransmissionType = findViewById(R.id.evTransmissionType);
        evTitleStatus = findViewById(R.id.evTitleStatus);
        //---------------------------------------------------------
    }

    public void onClick(View view) {//When button is clicked
        String year = evYear.getText().toString();    ////Set Strings to instanciate Car//////////
        String make = evMake.getText().toString();
        String model = evModel.getText().toString();
        String color = evColor.getText().toString();
        String engine = evEngine.getText().toString();
        String transmissionType = evTransmissionType.getText().toString();
        String titleStatus = evTitleStatus.getText().toString();

        //INSTANCIATE CAR
        Car car = new Car(year, make, model, color, engine, transmissionType, titleStatus);

        //Set up the "shared preferences" object
        sharedPreferences = getSharedPreferences("sharePref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();//Set up the editor
        editor.putString("make", make);//Put the variables
        editor.putString("model", model);
        editor.apply();//commit
        Log.d(TAG, "make "+sharedPreferences.getString("make", ""));
        Log.d(TAG, "model "+sharedPreferences.getString("model", ""));

        //Set up the intent to pass the parcelable object
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("car", car);//put the object to the intent
        setResult(666, intent);//Cock the for result trigger
        finish();//Fire the trigger
    }
}
