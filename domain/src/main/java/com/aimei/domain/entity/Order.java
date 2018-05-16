package com.aimei.domain.entity;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private String orderDetailId;
    private Date orderGenDate;
    private String memberName;
    private String memberId;
    private String phone;
    private String address;
    private String email;
    private int status;
    private double price;
    private List<Goods> goods;
    private List<ShoppingCar> shoppingCars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Date getOrderGenDate() {
        return orderGenDate;
    }

    public void setOrderGenDate(Date orderGenDate) {
        this.orderGenDate = orderGenDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<ShoppingCar> getShoppingCars() {
        return shoppingCars;
    }

    public void setShoppingCars(List<ShoppingCar> shoppingCars) {
        this.shoppingCars = shoppingCars;
    }
}
