package com.deepcloud.been;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午3:25 2018/6/25
 * @ Description：车辆类的封装类
 */
public class Car {

    private String carID;
    private String carBrand;
    private String carModel;
    private String carStruct;
    private double carDisplacement;
    private boolean isManual;
    private int maxMum;
    private double originalPrice;
    private double discount;

    public Car() {

    }

    public Car(String carID, String carBrand, String carModel, String carStruct, double carDisplacement, boolean isManual, int maxMum, double originalPrice, double discount) {
        this.carID = carID;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carStruct = carStruct;
        this.carDisplacement = carDisplacement;
        this.isManual = isManual;
        this.maxMum = maxMum;
        this.originalPrice = originalPrice;
        this.discount = discount;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarStruct() {
        return carStruct;
    }

    public void setCarStruct(String carStruct) {
        this.carStruct = carStruct;
    }

    public double getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(double carDisplacement) {
        this.carDisplacement = carDisplacement;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public int getMaxMum() {
        return maxMum;
    }

    public void setMaxMum(int maxMum) {
        this.maxMum = maxMum;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID='" + carID + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carStruct='" + carStruct + '\'' +
                ", carDisplacement=" + carDisplacement +
                ", isManual=" + isManual +
                ", maxMum=" + maxMum +
                ", originalPrice=" + originalPrice +
                ", discount=" + discount +
                '}';
    }
}
