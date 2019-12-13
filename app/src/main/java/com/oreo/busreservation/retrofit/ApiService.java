package com.oreo.busreservation.retrofit;

import com.oreo.busreservation.domain.Admin;
import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.domain.TicketDetail;

import com.oreo.busreservation.domain.Member;

import java.sql.Timestamp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/ticket/list")
    Call<List<TicketDetail>> getTicketList(@Query("member_id") int member_id);

    @GET("/ticket/detail")
    Call<TicketDetail> getTicketDetail(@Query("id") int id);

    @GET("/user/login")
    Call<Member> getMember(@Query("userID") String userID, @Query("userPWD") String userPWD);

    @POST("/user/signup")
    Call<Boolean> insertMember(@Query("userID") String userID,
                               @Query("userPWD") String userPWD,
                               @Query("name") String name,
                               @Query("email") String email
    );

    @GET("/bus/list")
    Call<List<Bus>> getBusList(@Query("departure") String departure, @Query("arrival") String arrival, @Query("date") Timestamp date);

    @GET("/bus/detail")
    Call<Bus> getBusDetail(@Query("busId") int busId);

    @GET("/admin/memeber/list")
    Call<List<Member>> getMemberList();

    @POST("bus/register")
        // depart_time is long???
        // TODO : 백엔드에서는 TimeStamp로 입력받도록 되어있습니다. 확인 필요할듯
    Call<Boolean> busRegister(@Query("departure") String departure,
                              @Query("arrival") String arrival,
                              @Query("depart_time") Timestamp depart_time,
                              @Query("arrive_time") Timestamp arrive_time,
                              @Query("type") String type,
                              @Query("company") String company,
                              @Query("price") int price
    );

    @GET("/admin/login")
    Call<Admin> getAdmin(@Query("adminID") String adminID, @Query("adminPWD") String adminPWD);

    @POST("/ticket/register")
    Call<Boolean> insertTicket(@Query("bus_id") int busId, @Query("member_id") int memberId);
}