package com.oreo.busreservation.domain;

import java.io.Serializable;
import java.sql.Timestamp;

//todo 임시 Bus 객체
public class Bus implements Serializable {
    private Timestamp departureTime;
    private String departure;
    private String arrival;

    public Bus(Timestamp departureTime, String departure, String arrival) {
        this.departureTime = departureTime;
        this.departure = departure;
        this.arrival = arrival;
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
