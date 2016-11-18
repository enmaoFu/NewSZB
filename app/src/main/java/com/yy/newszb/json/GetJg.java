package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 获取远程分析结果返回 JSON 实体类
 * @author fuenmao
 */
public class GetJg {

    @Expose
    private int status;

    @Expose
    private DataJg data;

    @Expose
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataJg getData() {
        return data;
    }

    public void setData(DataJg data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
