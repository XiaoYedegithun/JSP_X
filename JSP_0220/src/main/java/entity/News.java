package entity;

public class News {
    private Integer nid;
    private String ntitle;
    private String nauthor;
    private String nbak;
    private String ncontent;



    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    private Integer tid;
    private String images;
    private String ndate;

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
