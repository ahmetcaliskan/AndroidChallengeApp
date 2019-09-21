package com.c.a.androidchallengeapp.model;

import com.google.gson.annotations.SerializedName;

public class ModelOrders {
    @SerializedName("date")
    private String date;

    @SerializedName("month")
    private String month;

    @SerializedName("marketName")
    private String marketName;

    @SerializedName("orderName")
    private String orderName;

    @SerializedName("productPrice")
    private double productPrice;

    @SerializedName("productState")
    private String productState;

    @SerializedName("productDetail")
    private ModelProductDetail modelProductDetail;

    private boolean isExpand;//Recylerview'de, scroll anında expandable view'in son halini korumak için

    public ModelOrders() {
    }

    public ModelOrders(String date, String month, String marketName, String orderName, double productPrice,
                       String productState, ModelProductDetail modelProductDetail, boolean isExpand) {
        this.date = date;
        this.month = month;
        this.marketName = marketName;
        this.orderName = orderName;
        this.productPrice = productPrice;
        this.productState = productState;
        this.modelProductDetail = modelProductDetail;
        this.isExpand = isExpand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public ModelProductDetail getModelProductDetail() {
        return modelProductDetail;
    }

    public void setModelProductDetail(ModelProductDetail modelProductDetail) {
        this.modelProductDetail = modelProductDetail;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }
}
