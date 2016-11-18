package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * Created by John on 2016/7/22.
 */
public class SSSList {

    @Expose
    private String id;

    @Expose
    private String truename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }
}
