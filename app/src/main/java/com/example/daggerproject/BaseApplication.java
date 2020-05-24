package com.example.daggerproject;

import com.example.daggerproject.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Rahul on 23/05/20.
 */
public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).builder();
    }
}
