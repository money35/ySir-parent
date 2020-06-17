package com.qfedu.cardemo.entity;

import java.util.List;

//用来描述一个分页数据模型
public class Page<T>{
    //显示对象集合
    private List<T> data;
    //分页信息
    private int page;//页码（当前页时第几页）
    private int size;//每页显示数据的条数
    private int pages;//总页数
    private int total;//数据总条数

    public Page() {
    }

    public Page(List<T> data, int page, int size, int total) {
        this.data = data;
        this.page = page;
        this.size = size;
        this.total = total;
        this.pages = this.total%this.size==0?this.total/this.size:(this.total/this.size)+1;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", page=" + page +
                ", size=" + size +
                ", pages=" + pages +
                ", total=" + total +
                '}';
    }
}
