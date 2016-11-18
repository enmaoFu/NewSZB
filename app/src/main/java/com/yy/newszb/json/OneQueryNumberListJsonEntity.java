package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 诊疗记录查询身份证号码返回 JSON 实体类
 * @author fuenmao
 */
public class OneQueryNumberListJsonEntity {

    @Expose
    private int status;

    @Expose
    private String msg;

    @Expose
    private List<OneQueryNumberListListJsonEntity> data;

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

    public List<OneQueryNumberListListJsonEntity> getData() {
        return data;
    }

    public void setData(List<OneQueryNumberListListJsonEntity> data) {
        this.data = data;
    }
}
