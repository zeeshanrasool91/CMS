package com.appabilities.complainmanagementsystem.base;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.appabilities.complainmanagementsystem.MyApplication;
import com.appabilities.complainmanagementsystem.utils.CommonActions;
import com.appabilities.complainmanagementsystem.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements IConectivityObserver {

    public CommonActions ca;
    public boolean isNetworkAvailable;
    protected List fragmentAdded = new ArrayList<String>();
    SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        ca = new CommonActions(this);
        //loginResponse = EasyPreference.with(this).getObject("loginResponse", LoginResponse.class);
        updateNetworkStatus();
    }


    public void updateNetworkStatus() {
        isNetworkAvailable = NetworkUtils.checkConnection(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        NetworkChangeReceiver.getObservable().deleteObserver(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        NetworkChangeReceiver.getObservable().addObserver(this);
        updateNetworkStatus();
        MyApplication.setCurrentActivity(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
