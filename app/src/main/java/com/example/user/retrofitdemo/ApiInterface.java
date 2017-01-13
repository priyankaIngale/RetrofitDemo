package com.example.user.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by USER on 07-01-2017.
 */

public interface ApiInterface {
    @GET("key/value/one/two")
    Call<Model> getvalue();
}
