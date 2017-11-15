package com.example.haneul.moilens;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by MSI PC on 2017-11-15.
 */

public class CustomStartApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Typekit.getInstance().addNormal(Typekit.createFromAsset(this, "fonts/NanumBarunGothic.otf"))
                .addBold(Typekit.createFromAsset(this,"fonts/NanumBarunGothicBold.otf"));

    }
}
