package com.example.daggerproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.example.daggerproject.models.User;
import com.example.daggerproject.ui.auth.AuthResource;
import com.example.daggerproject.ui.auth.AuthviewModel;
import com.example.daggerproject.viewModel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity  {

    private static final String TAG = "AuthActivity";

    private AuthviewModel authviewModel;
    LiveData<User> userLiveData = new MediatorLiveData<>();

    @Inject
    Drawable drawable;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    EditText userid;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);




         findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 subscribeUser();
             }
         });
        userid=findViewById(R.id.user_id_input);
        authviewModel = ViewModelProviders.of(this, providerFactory).get(AuthviewModel.class);


        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestManager.load(drawable).into((ImageView) findViewById(R.id.login_logo));
                subscribeUser();


            }
        });
    }



    public void subscribeUser() {

        Log.d(TAG, "subscribeUser: "+userid.getText().toString());
        authviewModel.authenticationWithId(Integer.parseInt(userid.getText().toString()));
        authviewModel.observerUser().observe(AuthActivity.this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                Log.e("jfvhjdsvfdhsfdsg",""+userAuthResource.data);
            }
        });
    }


}
