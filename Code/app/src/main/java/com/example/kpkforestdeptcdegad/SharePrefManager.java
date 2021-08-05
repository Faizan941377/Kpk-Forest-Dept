package com.example.kpkforestdeptcdegad;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.kpkforestdeptcdegad.Model.LoginModel;

public class SharePrefManager {

    public static final String SHARED_PREF_NAME = "credentials";
    private static SharePrefManager mInstance;
    private Context mCtx;

    private SharePrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized  SharePrefManager getInstance(Context mCtx){
        if (mInstance == null){
            mInstance = new SharePrefManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(LoginModel loginModel){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt("id", Integer.parseInt((loginModel.getId())));
            editor.putString("full_name", loginModel.getFull_name());
            editor.putString("email", loginModel.getEmail());
            editor.putString("mobile", loginModel.getMobile());
            editor.putString("image",loginModel.getImage());
            editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public LoginModel getUsers(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new LoginModel(
                sharedPreferences.getString("full_name",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("mobile",null),
                sharedPreferences.getString("image",null)
        );
    }

    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
