package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 心电记录查询身份证号码返回array JSON 实体类
 * @author fuenmao
 */
public class TwoQueryNumberListListJsonEntity {

    @Expose
    private String DID;

    @Expose
    private String id;

    @Expose
    private String cardnum;

    @Expose
    private String times;

    @Expose
    private String name;

    @Expose
    private String sex;

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
