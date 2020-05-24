package com.example.daggerproject.di;

import android.app.Application;

import com.example.daggerproject.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Rahul on 23/05/20.
 */

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        AppModule.class,
        ViewModelFactoryModule.class}
)
public interface AppComponent  extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent builder();
    }
}
