package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName = "manager")
public class Manager {
    @Column("managerid")
    private int managerid;

    @Column("accounts")
    private String accounts;

    @Column("username")
    private String username;

    @Column("userpwd")
    private String userpwd;

    public int getManagerid() {
        return managerid;
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

    public void setManagerid(int managerid) {
        this.managerid = managerid;
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
}
