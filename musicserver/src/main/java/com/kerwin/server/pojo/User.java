package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName = "user")
public class User {
    @Column("userid")
    private int userid;

    @Column("accounts")
    private String accounts;

    @Column("username")
    private String username;

    @Column("userpwd")
    private String userpwd;

    @Column("sex")
    private String sex;

    @Column("age")
    private int age;

    @Column("telephone")
    private String telephone;

    @Column("email")
    private String email;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public String getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", accounts='" + accounts + '\'' +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
