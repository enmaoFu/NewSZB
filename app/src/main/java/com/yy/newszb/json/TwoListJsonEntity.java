package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 心电记录列表返回 JSON 实体类
 * @author fuenmao
 */
public class TwoListJsonEntity {

    @Expose
    private int status;

    @Expose
    private String msg;

    @Expose
    private List<TwoListListJsonEntity> data;

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

    public List<TwoListListJsonEntity> getData() {
        return data;
    }

    public void setData(List<TwoListListJsonEntity> data) {
        this.data = data;
    }

}
