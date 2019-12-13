package com.oreo.busreservation.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TicketDetail implements Serializable {
    @SerializedName("ticket_id")
    @Expose
    private int id;

    @SerializedName("ticket_bus_id")
    @Expose
    private int bus_id;

    @SerializedName("ticket_member_id")
    @Expose
    private int member_id;

    @SerializedName("ticket_info")
    @Expose
    private int info;

    @SerializedName("bus_departure")
    @Expose
    private String departure;

    @SerializedName("bus_arrival")
    @Expose
    private String arrival;

    @SerializedName("bus_depart_time")
    @Expose
    private String departTime;

    @SerializedName("bus_arrive_time")
    @Expose
    private String arriveTime;

    @SerializedName("bus_type")
    @Expose
    private String type;

    @SerializedName("bus_company")
    @Expose
    private String company;

    @SerializedName("bus_price")
    @Expose
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
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

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
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
        return "TicketDetail{" +
                "id=" + id +
                ", bus_id=" + bus_id +
                ", member_id=" + member_id +
                ", info=" + info +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departTime='" + departTime + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}