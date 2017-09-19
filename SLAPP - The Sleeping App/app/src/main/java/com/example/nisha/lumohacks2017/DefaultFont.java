package com.example.nisha.lumohacks2017;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by yanan on 9/18/2017.
 */

public class DefaultFont extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/opensans-regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
