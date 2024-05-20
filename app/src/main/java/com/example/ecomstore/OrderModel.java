package com.example.ecomstore;

public class OrderModel {
    private String orderNumber;
    private String customerName;

    private String customerNumber;
    private String customerAddress;
    private String itemExpense;
    private String deliveryCharges;
    private String orderTrackingNumber;
    private String courier;
    private String orderPalcingDate;
    private String orderStatus;

    private String uid;

    public OrderModel() {
    }

    public OrderModel(String orderNumber, String customerName, String customerNumber, String customerAddress, String itemExpense, String deliveryCharges, String orderTrackingNumber, String courier, String orderPalcingDate, String orderStatus, String uid) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.itemExpense = itemExpense;
        this.deliveryCharges = deliveryCharges;
        this.orderTrackingNumber = orderTrackingNumber;
        this.courier = courier;
        this.orderPalcingDate = orderPalcingDate;
        this.orderStatus = orderStatus;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getItemExpense() {
        return itemExpense;
    }

    public void setItemExpense(String itemExpense) {
        this.itemExpense = itemExpense;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getOrderPalcingDate() {
        return orderPalcingDate;
    }

    public void setOrderPalcingDate(String orderPalcingDate) {
        this.orderPalcingDate = orderPalcingDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
