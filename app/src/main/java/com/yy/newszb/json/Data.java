package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

/**
 * Created by John on 2016/11/18.
 */
public class Data {

    @Expose
    private String did;

    @Expose
    private String id;

    @Expose
    private String gid;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
}
