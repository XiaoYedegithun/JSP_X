package com.xy.entity;

public class News {
    private Integer nid;
    private String ntitle;
    private String nauthor;
    private String nbak;
    private String ncontent;
    private Integer tid;
    private String images;
    private String ndate;

    public News(){}

    public News(Integer nid, String ntitle, String nauthor, String nbak, String ncontent, Integer tid, String images, String ndate) {
        this.nid = nid;
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.nbak = nbak;
        this.ncontent = ncontent;
        this.tid = tid;
        this.images = images;
        this.ndate = ndate;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", ntitle='" + ntitle + '\'' +
                ", nauthor='" + nauthor + '\'' +
                ", nbak='" + nbak + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", tid=" + tid +
                ", images='" + images + '\'' +
                ", ndate='" + ndate + '\'' +
                '}';
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public String getNbak() {
        return nbak;
    }

    public void setNbak(String nbak) {
        this.nbak = nbak;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNdate() {
        return ndate;
    }

    public void setNdate(String ndate) {
        this.ndate = ndate;
    }
}
