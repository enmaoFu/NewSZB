package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * Created by John on 2016/11/18.
 */

public class SendYz {

    @Expose
    private int status;

    @Expose
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
