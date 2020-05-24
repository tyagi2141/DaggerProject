package com.example.daggerproject.di.auth;

import androidx.lifecycle.ViewModel;

import com.example.daggerproject.di.ViewModelKey;
import com.example.daggerproject.ui.auth.AuthviewModel;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Rahul on 24/05/20.
 */

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthviewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthviewModel authviewModel);

}
