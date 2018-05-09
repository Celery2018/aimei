package com.aimei.domain.entity;

import java.util.Date;

/**
 * 库存
 */
public class Stock {
    private String id;
    private String goodsId;
    private String memberId;
    private String numbers;
    private Date purchaseTime;
    private int wetherPurchase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getWetherPurchase() {
        return wetherPurchase;
    }

    public void setWetherPurchase(int wetherPurchase) {
        this.wetherPurchase = wetherPurchase;
    }
}
