package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 心电记录查询身份证号码返回 JSON 实体类
 * @author fuenmao
 */
public class TwoQueryNumberListJsonEntity {

    @Expose
    private int status;

    @Expose
    private String msg;

    @Expose
    private List<TwoQueryNumberListListJsonEntity> data;

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

    public List<TwoQueryNumberListListJsonEntity> getData() {
        return data;
    }

    public void setData(List<TwoQueryNumberListListJsonEntity> data) {
        this.data = data;
    }

}
