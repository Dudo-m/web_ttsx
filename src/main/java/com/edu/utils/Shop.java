package com.edu.utils;

import com.edu.entity.Good;

public class Shop {
    private int sId;
    private Good good;
    private int num;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "sId=" + sId +
                ", good=" + good +
                ", num=" + num +
                '}';
    }
}
