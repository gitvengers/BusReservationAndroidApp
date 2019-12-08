package com.oreo.busreservation.domain;

import java.io.Serializable;
import java.sql.Timestamp;

//todo 임시 Bus 객체
public class Bus implements Serializable {
    private String departure;
    private String arrival;
    private Timestamp departureTime;
    private Timestamp arriveTime;
    private String type;
    private String company;
    private int price;

    public Bus(Timestamp departureTime, String departure, String arrival) {
        this.departureTime = departureTime;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Bus(String departure, String arrival, Timestamp departureTime, Timestamp arriveTime, String type, String company,int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.type = type;
        this.company = company;
        this.price = price;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
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
}
