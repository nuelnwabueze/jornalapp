package com.example.android.jornalapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by USER on 6/29/2018.
 */

public class jornalapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
