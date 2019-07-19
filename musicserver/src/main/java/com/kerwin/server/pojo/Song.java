package com.kerwin.server.pojo;

import jdbc2.Column;
import jdbc2.Table;

@Table(tableName = "songs")
public class Song{
    @Column("songid")
    private int songid;

    @Column("singerid")
    private int singerid;

    @Column("albumid")
    private int albumid;

    @Column("songname")
    private String songname;

    @Column("songpic")
    private String songpic;

    @Column("songreleaseDate")
    private String songreleaseDate;

    @Column("songTimeMinutes")
    private String songTimeMinutes;

    @Column("singername")
    private String singername;

    @Column("albumname")
    private String albumname;

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public void setSongpic(String songpic) {
        this.songpic = songpic;
    }

    public void setSongreleaseDate(String songreleaseDate) {
        this.songreleaseDate = songreleaseDate;
    }

    public void setSongTimeMinutes(String songTimeMinutes) {
        this.songTimeMinutes = songTimeMinutes;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getSongid() {
        return songid;
    }

    public int getSingerid() {
        return singerid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public String getSongname() {
        return songname;
    }

    public String getSongpic() {
        return songpic;
    }

    public String getSongreleaseDate() {
        return songreleaseDate;
    }

    public String getSongTimeMinutes() {
        return songTimeMinutes;
    }

    public String getSingername() {
        return singername;
    }

    public String getAlbumname() {
        return albumname;
    }
}
