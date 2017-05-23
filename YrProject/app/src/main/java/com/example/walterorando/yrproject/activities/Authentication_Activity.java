package com.example.walterorando.yrproject.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.fragments.Log_in_fragment;
import com.example.walterorando.yrproject.fragments.Sign_Up_fragment;

/**
 * Created by Walter Orando on 3/24/2016.
 */
public class Authentication_Activity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    public static final int INDEX_LOGIN = 0;
    public static final int INDEX_SIGN_UP= 1;

    private static final String STATE_SELECTED_FRAGMENT_INDEX = "selected_fragment_index";
    public static final String FRAGMENT_TAG = "fragment_tag";

    // Storage for camera image URI components
    private final static String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    private final static String CAPTURED_PHOTO_URI_KEY = "mCapturedImageURI";
    private String mCurrentPhotoPath = null;
    private Uri mCapturedImageURI = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        mFragmentManager = getSupportFragmentManager();
        if (getIntent().hasExtra("login")) {
            toggleFragment(INDEX_LOGIN);
        } else if(getIntent().hasExtra("signup")){
            toggleFragment(INDEX_SIGN_UP);
        }

    }

    private void toggleFragment(int index) {
        Fragment fragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (index){
            case INDEX_LOGIN:
                transaction.replace(android.R.id.content,new Log_in_fragment(),FRAGMENT_TAG);
                break;
            case INDEX_SIGN_UP:
                transaction.replace(android.R.id.content, new Sign_Up_fragment(),FRAGMENT_TAG);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (mCurrentPhotoPath != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_PATH_KEY, mCurrentPhotoPath);
        }
        if (mCapturedImageURI != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_URI_KEY, mCapturedImageURI.toString());
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_PATH_KEY)) {
            mCurrentPhotoPath = savedInstanceState.getString(CAPTURED_PHOTO_PATH_KEY);
        }
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_URI_KEY)) {
            mCapturedImageURI = Uri.parse(savedInstanceState.getString(CAPTURED_PHOTO_URI_KEY));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }


    public String getCurrentPhotoPath() {
        return mCurrentPhotoPath;
    }

    public void setCurrentPhotoPath(String mCurrentPhotoPath) {
        this.mCurrentPhotoPath = mCurrentPhotoPath;
    }

    public Uri getCapturedImageURI() {
        return mCapturedImageURI;
    }

    public void setCapturedImageURI(Uri mCapturedImageURI) {
        this.mCapturedImageURI = mCapturedImageURI;
    }

}
