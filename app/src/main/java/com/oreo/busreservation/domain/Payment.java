package com.oreo.busreservation.domain;

public class Payment {
    private long dateTime;
    private String company;
    private int price;

    public Payment(long dateTime, String company, int price) {
        this.dateTime = dateTime;
        this.company = company;
        this.price = price;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
