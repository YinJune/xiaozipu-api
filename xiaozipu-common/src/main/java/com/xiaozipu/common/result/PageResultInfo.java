package com.xiaozipu.common.result;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:17
 * @description:
 */
public class PageResultInfo<T> extends ResultInfo<T> {
    private Integer currentPage;
    private Long total;
    private Integer pageSize = 20;

    public PageResultInfo(Integer currentPage, Long total, T data) {
        super(data);
        this.currentPage = currentPage;
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
