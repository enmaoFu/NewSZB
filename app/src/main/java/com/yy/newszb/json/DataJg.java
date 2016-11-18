package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * Created by John on 2016/6/17.
 */
public class DataJg{

    @Expose
    private String id;

    @Expose
    private String wid;

    @Expose
    private String uid;

    @Expose
    private String hid;

    @Expose
    private String result;

    @Expose
    private String status;

    @Expose
    private String times;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
