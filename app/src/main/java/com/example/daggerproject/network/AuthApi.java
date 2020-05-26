package com.example.daggerproject.network;

import com.example.daggerproject.models.User;
import com.example.daggerproject.ui.auth.AuthResource;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Rahul on 25/05/20.
 */
public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}