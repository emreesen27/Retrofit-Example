package com.push.randomuserretrofit.RestApi;

import com.push.randomuserretrofit.Models.Repository;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static final ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {

        return ourInstance;
    }

    public Call<Repository> getCall() {
        return getRestApi().fetch();
    }


}
