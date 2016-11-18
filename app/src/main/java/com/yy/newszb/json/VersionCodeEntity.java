package com.yy.newszb.json;

import java.util.List;

/**
 * 检测版本返回 JSON 实体类
 * @author fuenmao
 */
public class VersionCodeEntity {

    private int status;

    private String url;

    private int versionCode;

    private List<String> msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

}
