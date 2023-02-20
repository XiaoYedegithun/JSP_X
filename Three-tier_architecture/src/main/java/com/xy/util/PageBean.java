package com.xy.util;

import javax.servlet.http.HttpServletRequest;

public class PageBean {
    /**
     * 定义页码
     */
    private Integer page = 1;
    /**
     * 定义每页显示多少条
     */
    private Integer rows = 5;
    /**
     * 定义总条目数
     */
    private Integer total = 0;

    public int startPage() {
        return (this.page - 1) * rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 通过总条数除以每页显示的条数得到总页数
     *
     * @return 总页数
     */
    public int getMax() {
        if (this.total % this.rows == 0) {
            return this.total / this.rows;
        } else {
            return this.total / this.rows + 1;
        }
    }

    /**
     * 通过网页传来的数据设置当前页码和每页显示的数据条数
     *
     * @param req
     */
    public void setRequest(HttpServletRequest req) {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        if (page != null) {
            this.page = Integer.parseInt(page);
        }
        if (rows != null) {
            this.rows = Integer.valueOf(rows);
        }
    }

    public int prevPage() {
        int n = this.page - 1;
        if (n <= 0) {
            n = 1;
        }
        return n;
    }

    public int nextPage() {
        int n = this.page;
        int max = getMax();
        int next = this.page + 1;
        if (next > max) {
            n = max;
        } else {
            n = this.page + 1;
        }
        return n;
    }

}
