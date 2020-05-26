package com.example.daggerproject.di.auth;

import com.example.daggerproject.network.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Rahul on 25/05/20.
 */

@Module
public class AuthModule {
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){

        return retrofit.create(AuthApi.class);
    }
}
