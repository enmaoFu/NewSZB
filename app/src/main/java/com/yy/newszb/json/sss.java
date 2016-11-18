package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 远程医生返回 JSON 实体类
 * @author fuenmao
 */
public class sss {

    @Expose
    private String status;

    @Expose
    private String msg;

    @Expose
    private List<SSSList> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SSSList> getData() {
        return data;
    }

    public void setData(List<SSSList> data) {
        this.data = data;
    }
}
