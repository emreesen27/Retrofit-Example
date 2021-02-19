package com.push.randomuserretrofit.Models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("results")
    @Expose
    private List<ResultsItem> results;

    public List<ResultsItem> getResults() {
        return results;
    }

}