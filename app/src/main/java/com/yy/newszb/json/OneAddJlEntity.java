package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 新增诊疗记录返回 JSON 实体类
 * @author fuenmao
 */
public class OneAddJlEntity {

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
