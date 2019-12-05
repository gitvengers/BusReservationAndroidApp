package com.oreo.busreservation.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("user_pwd")
    @Expose
    private String userPw;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    private static Member user = new Member();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Member getInstance() {
        return user;
    }

    public void setMember(Member member) {
        setId(member.getId());
        setUserId(member.getUserId());
        setUserPw(member.getUserPw());
        setName(member.getName());
        setEmail(member.getEmail());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("님 환영합니다. 마이페이지");
        return sb.toString();
    }
}
