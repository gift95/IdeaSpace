package cn.yunhe.beans;

import java.util.List;

public class PageInfo {
    //页码总数
    private int pageCount;
    //数据总条数
    private int count;
    //页码索引
    private int pageIndex;
    //每页显示条数
    private int pageSize;
    //数据list集合
    private List<?> list;

    public PageInfo() {
    }

    public PageInfo(int pageCount, int count, int pageIndex, int pageSize, List<?> list) {
        this.pageCount = pageCount;
        this.count = count;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.list = list;
    }

    public int getPageCount() {

        return count % pageSize == 0 ? (count / pageSize) : ((count / pageSize) + 1);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageCount=" + pageCount +
                ", count=" + count +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
