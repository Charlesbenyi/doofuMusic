package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName = "singer")
public class Singer {

    @Column("singerid")
    private int singerid;

    @Column("funsnum")
    private int funsnum;

    @Column("singerimg")
    private String singerimg;

    @Column("singername")
    private String singername;

    @Column("englishname")
    private String englishname;

    @Column("sex")
    private String sex;

    @Column("address")
    private String address;

    @Column("city")
    private String city;

    @Column("slanguage")
    private String slanguage;

    @Column("birthday")
    private String birthday;

    @Column("xingzuo")
    private String xingzuo;

    @Column("height")
    private String height;

    @Column("kg")
    private String kg;

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public void setFunsnum(int funsnum) {
        this.funsnum = funsnum;
    }

    public void setSingerimg(String singerimg) {
        this.singerimg = singerimg;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSlanguage(String slanguage) {
        this.slanguage = slanguage;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public int getSingerid() {
        return singerid;
    }

    public int getFunsnum() {
        return funsnum;
    }

    public String getSingerimg() {
        return singerimg;
    }

    public String getSingername() {
        return singername;
    }

    public String getEnglishname() {
        return englishname;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getSlanguage() {
        return slanguage;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public String getHeight() {
        return height;
    }

    public String getKg() {
        return kg;
    }
}
