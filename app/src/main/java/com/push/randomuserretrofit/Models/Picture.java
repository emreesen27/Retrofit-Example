package com.push.randomuserretrofit.Models;

import com.google.gson.annotations.SerializedName;

public class Picture {

    @SerializedName("large")
    private String large;

    public String getLarge() {
        return large;
    }

}