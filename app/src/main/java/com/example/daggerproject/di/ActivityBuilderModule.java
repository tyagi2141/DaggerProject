package com.example.daggerproject.di;

import com.example.daggerproject.AuthActivity;
import com.example.daggerproject.di.auth.AuthModule;
import com.example.daggerproject.di.auth.AuthViewModelModule;
import com.example.daggerproject.ui.auth.AuthviewModel;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Rahul on 23/05/20.
 */

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {
            AuthViewModelModule.class,
            AuthModule.class
    })
    abstract AuthActivity authActivity();



}
