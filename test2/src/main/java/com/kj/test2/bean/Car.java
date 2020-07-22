package com.kj.test2.bean;

import android.content.Context;
import android.widget.Toast;

import com.kj.test2.ui.layout.MainActivity;

public class Car{
    private int mModel;
    private MainActivity MainActivity;

    public Car(int mModel, com.kj.test2.ui.layout.MainActivity mainActivity) {
        this.mModel = mModel;
        MainActivity = mainActivity;
        setup();
    }

    private void setup() {
        String message = "Created a car of model number " + mModel + ".";

       Context context;
       Toast toast = Toast.makeText(MainActivity, message, Toast.LENGTH_SHORT);
       toast.show();
    }
}
