package com.example.nisha.lumohacks2017;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by yanan on 9/18/2017.
 */

public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ComicSans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //....
    }
}