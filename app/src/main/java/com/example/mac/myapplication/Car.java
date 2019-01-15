package com.example.mac.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**********************************************************************
 * NEARLY ALL OF THIS CLASS WAS AUTO GENERATED
 **********************************************************************/

public class Car implements Parcelable {

    private String year;
    private String make;
    private String model;
    private String color;
    private String engine;
    private String transmissionType;
    private String titleStatus;


    public Car(Parcel in) {
        year = in.readString();
        make = in.readString();
        model = in.readString();
        color = in.readString();
        engine = in.readString();
        transmissionType = in.readString();
        titleStatus = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(year);
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(color);
        dest.writeString(engine);
        dest.writeString(transmissionType);
        dest.writeString(titleStatus);
    }

    public Car(String year, String make, String model, String color, String engine, String transmissionType, String titleStatus) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.transmissionType = transmissionType;
        this.titleStatus = titleStatus;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getTitleStatus() {
        return titleStatus;
    }

    public void setTitleStatus(String titleStatus) {
        this.titleStatus = titleStatus;
    }

    public static Creator<Car> getCREATOR() {
        return CREATOR;
    }
}
