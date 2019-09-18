package com.c.a.androidchallengeapp.model;

import com.google.gson.annotations.SerializedName;

public class ModelProductDetail {
    @SerializedName("orderDetail")
    private String orderDetail;

    @SerializedName("summaryPrice")
    private double summaryPrice;

    public ModelProductDetail() {
    }

    public ModelProductDetail(String orderDetail, int summaryPrice) {
        this.orderDetail = orderDetail;
        this.summaryPrice = summaryPrice;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public double getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(double summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public void setSummaryPrice(int summaryPrice) {
        this.summaryPrice = summaryPrice;
    }
}
