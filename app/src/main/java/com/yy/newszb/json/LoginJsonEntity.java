package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 登陆返回 JSON 实体类
 * @author fuenmao
 */
public class LoginJsonEntity {

    @Expose
    private int status;

    @Expose
    private Data data;

    @Expose
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
