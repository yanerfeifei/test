package com.classmap;

import java.io.Serializable;

/**
 * Created by meridian on 2018/12/27.
 */
public class MonitorEarlywarnOrAlarmParam implements Serializable{
    /**
     * one开头:血压中是收缩压，血糖中是空腹血糖，其余则是，血氧饱和度，体温，腰围，睡眠总时长，运动全天消耗
     * two开头:血压中是舒张压，血糖中是随机血糖
     */
    private String oneMaxValue; //收缩压或者空腹血糖等的最大值
    private String oneMaxSymbol; //最大值符号<,<=
    private String oneMinValue; //收缩压或者空腹血糖等的最小值
    private String oneMinSymbol; //最小值符号>,>=
    private String twoMaxValue; //舒张压或者随机血糖的最大值
    private String twoMaxSymbol; //最大值符号<,<=
    private String twoMinValue; //舒张压或者随机血糖的最小值
    private String twoMinSymbol; //最小值符号>,>=

    public String getOneMaxValue() {
        return oneMaxValue;
    }

    public void setOneMaxValue(String oneMaxValue) {
        this.oneMaxValue = oneMaxValue;
    }

    public String getOneMaxSymbol() {
        return oneMaxSymbol;
    }

    public void setOneMaxSymbol(String oneMaxSymbol) {
        this.oneMaxSymbol = oneMaxSymbol;
    }

    public String getOneMinValue() {
        return oneMinValue;
    }

    public void setOneMinValue(String oneMinValue) {
        this.oneMinValue = oneMinValue;
    }

    public String getOneMinSymbol() {
        return oneMinSymbol;
    }

    public void setOneMinSymbol(String oneMinSymbol) {
        this.oneMinSymbol = oneMinSymbol;
    }

    public String getTwoMaxValue() {
        return twoMaxValue;
    }

    public void setTwoMaxValue(String twoMaxValue) {
        this.twoMaxValue = twoMaxValue;
    }

    public String getTwoMaxSymbol() {
        return twoMaxSymbol;
    }

    public void setTwoMaxSymbol(String twoMaxSymbol) {
        this.twoMaxSymbol = twoMaxSymbol;
    }

    public String getTwoMinValue() {
        return twoMinValue;
    }

    public void setTwoMinValue(String twoMinValue) {
        this.twoMinValue = twoMinValue;
    }

    public String getTwoMinSymbol() {
        return twoMinSymbol;
    }

    public void setTwoMinSymbol(String twoMinSymbol) {
        this.twoMinSymbol = twoMinSymbol;
    }
}
