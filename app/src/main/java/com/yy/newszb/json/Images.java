package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * Created by John on 2016/11/18.
 */

public class Images {

    @Expose
    private String img1;

    @Expose
    private String img2;

    @Expose
    private String img3;

    @Expose
    private String img4;

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }
}
