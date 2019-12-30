package com.java.springboot.sms.entity;

public class Result {
    private String formattedAddress;
    private Geometry geometry;

    public Result() {}

    public Result(String formattedAddress, Geometry geometry) {
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Result{" +
                "formattedAddress='" + formattedAddress + '\'' +
                ", geometry=" + geometry +
                '}';
    }
}
