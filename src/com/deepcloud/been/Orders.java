package com.deepcloud.been;

import java.util.Date;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午3:26 2018/6/25
 * @ Description：订单类的封装类
 */
public class Orders {

    private String orderNum;
    private String carID;
    private Date pickupTime;
    private Date returnTime;
    private boolean orderStatus;
    private double orderCost;


    public Orders() {

    }

    public Orders(String orderNum, String carID, Date pickupTime, Date returnTime, boolean orderStatus, double orderCost) {
        this.orderNum = orderNum;
        this.carID = carID;
        this.pickupTime = pickupTime;
        this.returnTime = returnTime;
        this.orderStatus = orderStatus;
        this.orderCost = orderCost;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderNum='" + orderNum + '\'' +
                ", carID='" + carID + '\'' +
                ", pickupTime=" + pickupTime +
                ", returnTime=" + returnTime +
                ", orderStatus=" + orderStatus +
                ", orderCost=" + orderCost +
                '}';
    }
}
