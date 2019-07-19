package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName ="shoucang")
public class Shoucang {
    @Column("id")
    private int id;

    @Column("userid")
    private int userid;

    @Column("songid")
    private int songid;

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public int getSongid() {
        return songid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    @Override
    public String toString() {
        return "Shoucang{" +
                "id=" + id +
                ", userid=" + userid +
                ", songid=" + songid +
                '}';
    }
}
