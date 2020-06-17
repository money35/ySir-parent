package com.qfedu.cardemo.entity;

//实体类
public class Car {
    private Integer id;
    private String carName;
    private String pl;
    private String carType;
    private Double price;
    private Integer mileage;
    private String productionDate;
    private String serial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", pl='" + pl + '\'' +
                ", carType='" + carType + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", productionDate='" + productionDate + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
