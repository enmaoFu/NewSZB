package com.yy.newszb.entitys;

/**
 * 健康教育实体类
 * @author fuenmao
 */
public class ThreeEntity {

    private String idss;

    private String name;

    private String id;

    private String date;

    public ThreeEntity(String idss, String name, String id, String date) {
        this.idss = idss;
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public String getIdss() {
        return idss;
    }

    public void setIdss(String idss) {
        this.idss = idss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
