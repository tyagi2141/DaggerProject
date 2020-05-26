package com.example.daggerproject.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.daggerproject.models.User;
import com.example.daggerproject.network.AuthApi;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rahul on 24/05/20.
 */
public class AuthviewModel extends ViewModel {
    private static final String TAG = "AuthviewModel";

    MediatorLiveData<AuthResource<User>> userMediatorLiveData= new MediatorLiveData<>();
  private final   AuthApi authApi;
    @Inject
    public AuthviewModel(AuthApi authApi) {
        this.authApi = authApi;
    }

    public void authenticationWithId(int userId){
        final LiveData<AuthResource<User>> source =
                LiveDataReactiveStreams.fromPublisher(authApi.getUser(userId).onErrorReturn(new Function<Throwable, User>() {
                    @Override
                    public User apply(Throwable throwable) throws Exception {
                        User errorUser= new User();
                        errorUser.setId(-1);
                        return errorUser;
                    }
                }).map(new Function<User, AuthResource<User>>() {
                    @Override
                    public AuthResource<User> apply(User user) throws Exception {
                        if (user.getId()== -1){
                            return AuthResource.error("could not connect",(User)null);
                        }
                        return AuthResource.authenticated(user);
                    }
                }).subscribeOn(Schedulers.io()));




        userMediatorLiveData.addSource(source, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null){
                    userMediatorLiveData.setValue(userAuthResource);
                    userMediatorLiveData.removeSource(source);


                }

            }
        });
    }
    public LiveData<AuthResource<User>> observerUser(){
        return userMediatorLiveData;
    }
}
