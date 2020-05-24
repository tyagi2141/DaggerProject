package com.example.daggerproject.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by Rahul on 24/05/20.
 */
public class AuthviewModel extends ViewModel {
    private static final String TAG = "AuthviewModel";
    @Inject
    public AuthviewModel() {

        Log.e(TAG, "AuthviewModel:  it is workin" );
    }
}
