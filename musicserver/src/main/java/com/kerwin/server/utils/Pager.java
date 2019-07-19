package com.kerwin.server.utils;

import com.kerwin.server.pojo.Singer;

import java.util.List;

public class Pager {

    private Integer indexpage = 1;
    private Integer countrows;
    private Integer countpage;
    private Integer pagesize = 14;
    private Integer beginrows;


    private List data;

    public void setData(List<Object> data) {
        this.data = data;
    }

    public List<Object> getData() {
        return data;
    }

    public Integer getBeginrows() {
        this.beginrows = ((getIndexpage() - 1) * getPagesize());
        return beginrows;
    }

    public Pager(Integer countrows,Integer indexpage) {
        this.countrows = countrows;
        this.indexpage = indexpage;
    }

    public Integer getCountrows() {
        return countrows;
    }

    public void setCountpage(Integer countpage) {
        this.countpage = countpage;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getIndexpage() {
        return indexpage;
    }



    public Integer getCountpage() {
        this.countpage = getCountrows() % getPagesize() == 0
                ? getCountrows() / getPagesize()
                : getCountrows() / getPagesize() + 1;
        return countpage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "indexpage=" + getIndexpage() +
                ", countrows=" + getCountrows() +
                ", countpage=" + getCountpage() +
                ", pagesize=" + getPagesize() +
                ", beginrows=" + getBeginrows() +
                '}';
    }
}
