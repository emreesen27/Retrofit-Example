package com.push.randomuserretrofit.RestApi;

import com.push.randomuserretrofit.Models.Repository;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/api")
    Call<Repository> fetch();
}
