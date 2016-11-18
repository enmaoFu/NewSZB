package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * 心电记录详情返回array JSON 实体类
 * @author fuenmao
 */
public class Imgagess{

    @Expose
    private List<String> img;

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }
}
