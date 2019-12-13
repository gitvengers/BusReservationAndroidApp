package com.oreo.busreservation.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Admin implements Serializable {
    @SerializedName("admin_id")
    @Expose
    private String id;

    @SerializedName("admin_pw")
    @Expose
    private String pw;

    private static Admin user = new Admin();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public static Admin getInstance() {
        return user;
    }

    public static void setAdmin(Admin admin) {
        user.setId(admin.id);
        user.setPw(admin.pw);
    }
}
