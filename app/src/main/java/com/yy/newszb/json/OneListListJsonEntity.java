package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * 诊疗记录列表返回array JSON 实体类
 * @author fuenmao
 */
public class OneListListJsonEntity {

    @Expose
    private String UID;

    @Expose
    private String NAME;

    @Expose
    private String TIME;

    @Expose
    private String ID;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
