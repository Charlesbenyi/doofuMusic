package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName = "album")
public class Album {

    @Column("albumid")
    private int albumid;

    @Column("singerid")
    private int singerid;

    @Column("albuminfo")
    private String albuminfo;

    @Column("albumartist")
    private String albumartist;

    @Column("albumreleaseDate")
    private String albumreleaseDate;

    @Column("albumname")
    private String albumname;

    @Column("albumpic")
    private String albumpic;

    @Column("lang")
    private String lang;

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public void setAlbuminfo(String albuminfo) {
        this.albuminfo = albuminfo;
    }

    public void setAlbumartist(String albumartist) {
        this.albumartist = albumartist;
    }

    public void setAlbumreleaseDate(String albumreleaseDate) {
        this.albumreleaseDate = albumreleaseDate;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public void setAlbumpic(String albumpic) {
        this.albumpic = albumpic;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getAlbumid() {
        return albumid;
    }

    public int getSingerid() {
        return singerid;
    }

    public String getAlbuminfo() {
        return albuminfo;
    }

    public String getAlbumartist() {
        return albumartist;
    }

    public String getAlbumreleaseDate() {
        return albumreleaseDate;
    }

    public String getAlbumname() {
        return albumname;
    }

    public String getAlbumpic() {
        return albumpic;
    }

    public String getLang() {
        return lang;
    }
}
