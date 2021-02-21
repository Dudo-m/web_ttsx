package com.edu.entity;

public class Address {
    private int aId;
    private int uId;
    private String aConsignee; //收件人
    private String aAddress; //地址
    private int aPC; //邮编
    private String aPhone; //手机

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getaConsignee() {
        return aConsignee;
    }

    public void setaConsignee(String aConsignee) {
        this.aConsignee = aConsignee;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public int getaPC() {
        return aPC;
    }

    public void setaPC(int aPC) {
        this.aPC = aPC;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public Address() {
    }

    public Address(int aId, int uId, String aConsignee, String aAddress, int aPC, String aPhone) {
        this.aId = aId;
        this.uId = uId;
        this.aConsignee = aConsignee;
        this.aAddress = aAddress;
        this.aPC = aPC;
        this.aPhone = aPhone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", aConsignee='" + aConsignee + '\'' +
                ", aAddress='" + aAddress + '\'' +
                ", aPC=" + aPC +
                ", aPhone=" + aPhone +
                '}';
    }
}
