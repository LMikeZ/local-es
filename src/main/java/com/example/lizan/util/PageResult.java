
package com.example.lizan.util;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ApiModel("分页实体")
public class PageResult<T> implements Serializable {
    @ApiModelProperty(
        value = "总条数",
        example = "1"
    )
    private long totalCount;
    @ApiModelProperty(
        value = "总页数",
        example = "1"
    )
    private long maxPage;
    @ApiModelProperty(
        value = "大小",
        example = "1"
    )
    private long pageSize;
    @ApiModelProperty(
        value = "当前页数",
        example = "1"
    )
    private long page;
    @ApiModelProperty("分页内容集合")
    private List<T> result;

    public static <T> PageResult<T> emptyPage() {
        PageResult emptyPage = builder().page(1L).maxPage(0L).totalCount(0L).pageSize(10L).result(Collections.emptyList()).build();
        return emptyPage;
    }

    public static <T> PageResult<T> changeValuesType(PageResult<?> sourcePage, List<T> values) {
        PageResult<T> pageData = new PageResult();
        pageData.setMaxPage(sourcePage.getMaxPage());
        pageData.setPageSize(sourcePage.getPageSize());
        pageData.setTotalCount(sourcePage.getTotalCount());
        pageData.setPage(sourcePage.getPage());
        pageData.setResult(values);
        return pageData;
    }

    public static <T> PageResultBuilder<T> builder() {
        return new PageResultBuilder();
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public long getMaxPage() {
        return this.maxPage;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getPage() {
        return this.page;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setTotalCount(final long totalCount) {
        this.totalCount = totalCount;
    }

    public void setMaxPage(final long maxPage) {
        this.maxPage = maxPage;
    }

    public void setPageSize(final long pageSize) {
        this.pageSize = pageSize;
    }

    public void setPage(final long page) {
        this.page = page;
    }

    public void setResult(final List<T> result) {
        this.result = result;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageResult;
    }



    public PageResult(final long totalCount, final long maxPage, final long pageSize, final long page, final List<T> result) {
        this.totalCount = totalCount;
        this.maxPage = maxPage;
        this.pageSize = pageSize;
        this.page = page;
        this.result = result;
    }

    public PageResult() {
    }


    public static class PageResultBuilder<T> {
        private long totalCount;
        private long maxPage;
        private long pageSize;
        private long page;
        private List<T> result;

        PageResultBuilder() {
        }

        public PageResultBuilder<T> totalCount(final long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public PageResultBuilder<T> maxPage(final long maxPage) {
            this.maxPage = maxPage;
            return this;
        }

        public PageResultBuilder<T> pageSize(final long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PageResultBuilder<T> page(final long page) {
            this.page = page;
            return this;
        }

        public PageResultBuilder<T> result(final List<T> result) {
            this.result = result;
            return this;
        }

        public PageResult<T> build() {
            return new PageResult(this.totalCount, this.maxPage, this.pageSize, this.page, this.result);
        }

        public String toString() {
            return "PageResult.PageResultBuilder(totalCount=" + this.totalCount + ", maxPage=" + this.maxPage + ", pageSize=" + this.pageSize + ", page=" + this.page + ", result=" + this.result + ")";
        }
    }
}
