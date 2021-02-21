package com.edu.entity;

public class Good {
    private int gId;
    private String gBrief; //简介
    private String gName; //名称
    private double gPrice;//价格
    private String gCompany; // 单位
    private String gStock; // 库存
    private String gImage; // 图片
    private String gType; // 分类

    public Good() {
    }

    public Good(int gId, String gBrief, String gName, double gPrice, String gCompany, String gStock, String gImage, String gType) {
        this.gId = gId;
        this.gBrief = gBrief;
        this.gName = gName;
        this.gPrice = gPrice;
        this.gCompany = gCompany;
        this.gStock = gStock;
        this.gImage = gImage;
        this.gType = gType;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgBrief() {
        return gBrief;
    }

    public void setgBrief(String gBrief) {
        this.gBrief = gBrief;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    public String getgCompany() {
        return gCompany;
    }

    public void setgCompany(String gCompany) {
        this.gCompany = gCompany;
    }

    public String getgStock() {
        return gStock;
    }

    public void setgStock(String gStock) {
        this.gStock = gStock;
    }

    public String getgImage() {
        return gImage;
    }

    public void setgImage(String gImage) {
        this.gImage = gImage;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    @Override
    public String toString() {
        return "Good{" +
                "gId=" + gId +
                ", gBrief='" + gBrief + '\'' +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gCompany='" + gCompany + '\'' +
                ", gStock='" + gStock + '\'' +
                ", gImage='" + gImage + '\'' +
                ", gType='" + gType + '\'' +
                '}';
    }
}
