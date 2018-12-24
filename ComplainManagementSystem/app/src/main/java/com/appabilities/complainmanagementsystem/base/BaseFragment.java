package com.appabilities.complainmanagementsystem.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import com.appabilities.complainmanagementsystem.utils.CommonActions;
import com.appabilities.complainmanagementsystem.utils.NetworkUtils;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.Observable;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment implements IConectivityObserver {

    public BaseActivity mActivity;
    public CommonActions ca;
    public boolean isNetworkAvailable;
    public ProgressDialog progressDialog;
    SharedPreferences mSharedPreferences;


    @CallSuper
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = (BaseActivity) this.getActivity();
        ca = new CommonActions(mActivity);
        updateNetworkStatus();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
    }

    public boolean onFragmentBackPressed() {
        return false;
    }

    public void updateNetworkStatus() {
        isNetworkAvailable = NetworkUtils.checkConnection(mActivity);
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
    }

    @Override
    public void update(Observable observable, Object data) {
        updateNetworkStatus();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String priceFormat(String price) {
        double amount = Double.parseDouble(price);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return formatter.format(amount);
    }

    protected String currentLanguage() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return mSharedPreferences.getString("user_preferred_language", "en");
    }
}
