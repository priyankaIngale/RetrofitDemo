package com.example.user.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 07-01-2017.
 */

public class Model {

    @SerializedName("one")
    @Expose
    private String one;
    @SerializedName("key")
    @Expose
    private String key;

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
