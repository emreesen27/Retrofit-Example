package com.push.randomuserretrofit.Models;

import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("phone")
    private String phone;

    @SerializedName("name")
    private Name name;

    @SerializedName("email")
    private String email;

    @SerializedName("picture")
    private Picture picture;


    public String getPhone() {
        return phone;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Picture getPicture() {
        return picture;
    }
}