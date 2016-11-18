package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 诊疗记录详情 JSON 实体类
 * @author fuenmao
 */
public class OneListXqJsonEntity {

    @Expose
    private int status;

    @Expose
    private OneListXqArrayJsonEntity data;

    @Expose
    private Images img;

    @Expose
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OneListXqArrayJsonEntity getData() {
        return data;
    }

    public void setData(OneListXqArrayJsonEntity data) {
        this.data = data;
    }

    public Images getImg() {
        return img;
    }

    public void setImg(Images img) {
        this.img = img;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
