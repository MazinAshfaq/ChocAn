package com.chocan.ProductService;

import java.util.Date;

public class Product {
    public Date currentDateAndTime; // MM-DD-YYYY HH:MM:SS
    public Date serviceDate; // MM-DD-YYYY
    public int providerNumber; // 9 digits
    public String providerName; // 25 chars
    public int memberNumber; // 9 digits
    public String memberName; // 25 chars
    public String serviceCode; // 6 digits
    public int fee; // Up to $999.99 (read provider directory for fees)
    public String comments; // 100 chars optional

    // General Constructor
    public Product(Date currentDateAndTime, Date serviceDate, int providerNumber, String providerName, int memberNumber, String memberName, String serviceCode, int fee, String comments) {
        this.currentDateAndTime = currentDateAndTime;
        this.serviceDate = serviceDate;
        this.providerNumber = providerNumber;
        this.providerName = providerName;
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.serviceCode = serviceCode;
        this.fee = fee;
        this.comments = comments;
    }

    public Date getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(Date currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Product{" +
                "currentDateAndTime=" + currentDateAndTime +
                ", serviceDate=" + serviceDate +
                ", providerNumber=" + providerNumber +
                ", providerName='" + providerName + '\'' +
                ", memberNumber=" + memberNumber +
                ", memberName='" + memberName + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", fee=" + fee +
                ", comments='" + comments + '\'' +
                '}';
    }
}
