package com.edu.utils;

import java.util.List;

public class Page {
    private String tableName;
    private String columns;
    private String whereStr;
    private String orderStr;
    private int pageSize;
    private int currentPage;
    //输出参数
    private int totalSize;
    private int totalPage;

    private int first = 1; // 首页
    private int previous;  // 上一页
    private int next;      //下一页
    private int last;      //尾页

    private List data;     //数据

    public Page() {
    }

    public Page(int currentPage) {
        this.currentPage = currentPage;
    }

    public Page(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public Page(String whereStr, String orderStr) {
        this.whereStr = whereStr;
        this.orderStr = orderStr;
    }

    public Page(String whereStr, String orderStr, int pageSize, int currentPage) {
        this.whereStr = whereStr;
        this.orderStr = orderStr;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public Page(String tableName, String columns, String whereStr, String orderStr, int pageSize, int currentPage) {
        this.tableName = tableName;
        this.columns = columns;
        this.whereStr = whereStr;
        this.orderStr = orderStr;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getWhereStr() {
        return whereStr;
    }

    public void setWhereStr(String whereStr) {
        this.whereStr = whereStr;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
