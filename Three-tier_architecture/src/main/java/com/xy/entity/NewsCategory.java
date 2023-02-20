package com.xy.entity;

public class NewsCategory {
    /**
     * 主题id
     */
    private Integer tid;
    /**
     * 主题的名字
     */
    private String tname;

    public NewsCategory() {

    }

    public NewsCategory(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "NewsCategory{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
