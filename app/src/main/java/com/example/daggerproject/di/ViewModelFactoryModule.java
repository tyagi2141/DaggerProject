package com.example.daggerproject.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.daggerproject.viewModel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Rahul on 24/05/20.
 */

@Module
public abstract class ViewModelFactoryModule {

    @Binds
   public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
