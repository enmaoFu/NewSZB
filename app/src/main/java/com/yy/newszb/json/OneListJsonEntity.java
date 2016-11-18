package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 诊疗记录列表返回 JSON 实体类
 * @author fuenmao
 */
public class OneListJsonEntity {

    @Expose
    private int status;

    @Expose
    private List<OneListListJsonEntity> data;

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

    public List<OneListListJsonEntity> getData() {
        return data;
    }

    public void setData(List<OneListListJsonEntity> data) {
        this.data = data;
    }
}
