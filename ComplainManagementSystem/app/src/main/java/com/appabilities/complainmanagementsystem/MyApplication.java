package com.appabilities.complainmanagementsystem;

import android.app.Activity;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

/**
 * Created by Admin on 9/3/2018.
 */

public class MyApplication extends MultiDexApplication {
    public static String APP_SETTINGS_FILE = "Jald Pay";
    private static Activity currentActivity = null;
    private static MyApplication mInstance;


    @Override
    public void onCreate() {
        super.onCreate();

        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SF-UI-Display-Medium.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/
        mInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Activity getCurrentActivity(){
        return currentActivity;
    }
    public static void setCurrentActivity(Activity mCurrentActivity){
        currentActivity = mCurrentActivity;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }


}
