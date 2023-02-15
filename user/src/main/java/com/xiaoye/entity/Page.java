package com.xiaoye.entity;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    // 页面大小
    private int pageSize;
    // 当前页码
    private int currentPageNo;
    // 总条数
    private int totalCount;
    // 总页数
    private int totalPageCount;
    // 显示的分页数据
    private List<T> list = new ArrayList<T>();

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            this.totalPageCount = this.totalCount % pageSize == 0
                    ? this.totalCount / this.pageSize
                    : this.totalCount / this.pageSize + 1;
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

//    public void setTotalPageCount(int totalPageCount) {
//        this.totalPageCount = totalPageCount;
//    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPageNo=" + currentPageNo +
                ", totalCount=" + totalCount +
                ", totalPageCount=" + totalPageCount +
                ", list=" + list +
                '}';
    }
}
