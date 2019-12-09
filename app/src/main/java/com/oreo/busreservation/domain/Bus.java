package com.oreo.busreservation.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//todo 임시 Bus 객체
public class Bus implements Serializable {
    @SerializedName("id")
    @Expose
    private int busId;

    @SerializedName("depart_time")
    @Expose
    private long departureTime;

    @SerializedName("arrive_time")
    @Expose
    private long arrivalTime;

    @SerializedName("departure")
    @Expose
    private String departure;

    @SerializedName("arrival")
    @Expose
    private String arrival;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("price")
    @Expose
    private int price;

    public Bus(long departureTime, String departure, String arrival) {
        this.departureTime = departureTime;
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}
