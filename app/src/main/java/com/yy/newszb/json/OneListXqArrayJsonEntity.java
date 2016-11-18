package com.yy.newszb.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 诊疗记录详情 array JSON 实体类
 * @author fuenmao
 */
public class OneListXqArrayJsonEntity implements Serializable{

    @Expose
    private String p_r;

    @Expose
    private String qrs;

    @Expose
    private String qt;

    @Expose
    private String qtc;

    @Expose
    private String p_axis;

    @Expose
    private String qrs_axis;

    @Expose
    private String t_axis;

    @Expose
    private String rv5;

    @Expose
    private String sv1;

    @Expose
    private String rv5_sv1;

    @Expose
    private String hr;

    @Expose
    private String analysis_desc;

    @Expose
    private String analysis_code;

    @Expose
    private String ID;

    @Expose
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getP_r() {
        return p_r;
    }

    public void setP_r(String p_r) {
        this.p_r = p_r;
    }

    public String getQrs() {
        return qrs;
    }

    public void setQrs(String qrs) {
        this.qrs = qrs;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getQtc() {
        return qtc;
    }

    public void setQtc(String qtc) {
        this.qtc = qtc;
    }

    public String getP_axis() {
        return p_axis;
    }

    public void setP_axis(String p_axis) {
        this.p_axis = p_axis;
    }

    public String getQrs_axis() {
        return qrs_axis;
    }

    public void setQrs_axis(String qrs_axis) {
        this.qrs_axis = qrs_axis;
    }

    public String getT_axis() {
        return t_axis;
    }

    public void setT_axis(String t_axis) {
        this.t_axis = t_axis;
    }

    public String getRv5() {
        return rv5;
    }

    public void setRv5(String rv5) {
        this.rv5 = rv5;
    }

    public String getSv1() {
        return sv1;
    }

    public void setSv1(String sv1) {
        this.sv1 = sv1;
    }

    public String getRv5_sv1() {
        return rv5_sv1;
    }

    public void setRv5_sv1(String rv5_sv1) {
        this.rv5_sv1 = rv5_sv1;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getAnalysis_desc() {
        return analysis_desc;
    }

    public void setAnalysis_desc(String analysis_desc) {
        this.analysis_desc = analysis_desc;
    }

    public String getAnalysis_code() {
        return analysis_code;
    }

    public void setAnalysis_code(String analysis_code) {
        this.analysis_code = analysis_code;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
