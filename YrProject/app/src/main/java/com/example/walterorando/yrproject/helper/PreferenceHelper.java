package com.example.walterorando.yrproject.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Walter Orando on 3/24/2016.
 */

public class PreferenceHelper {

    private static SharedPreferences mSharedPreferences;

    public static boolean setAccessToken(String token, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("access_token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("access_token", token);
        return editor.commit();
    }

    public static String getAccessToken(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("access_token", Context.MODE_PRIVATE);
        return mSharedPreferences.getString("access_token", null);
    }


    public static void logOut(Context mContext) {
        setAccessToken(null, mContext);

    }



}
