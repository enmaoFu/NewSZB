package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 心电记录详情返回 JSON 实体类
 * @author fuenmao
 */
public class TwoXqJsonEntity {

    @Expose
    private int status;

    @Expose
    private List<TwoXqListJsonEntity> data;

    @Expose
    private String msg;

    private List<String> img;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TwoXqListJsonEntity> getData() {
        return data;
    }

    public void setData(List<TwoXqListJsonEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }
}

