package com.push.randomuserretrofit.RestApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private final RestApi mRestApi;

    public RestApiClient(String restApiServiceUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRestApi = retrofit.create(RestApi.class);

    }

    public RestApi getRestApi() {
        return mRestApi;
    }
}
