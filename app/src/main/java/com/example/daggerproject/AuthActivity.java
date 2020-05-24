package com.example.daggerproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.example.daggerproject.ui.auth.AuthviewModel;
import com.example.daggerproject.viewModel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthviewModel authviewModel;

    @Inject
    Drawable drawable;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authviewModel = ViewModelProviders.of(this, providerFactory).get(AuthviewModel.class);
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestManager.load(drawable).into((ImageView) findViewById(R.id.login_logo));

            }
        });
    }


}
