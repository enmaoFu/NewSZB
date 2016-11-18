package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 远程分析返回 JSON 实体
 * @author fuenmao
 */
public class LongRangRntity {

    @Expose
    private int status;

    @Expose
    private String data;

    @Expose
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
