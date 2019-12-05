package com.oreo.busreservation.retrofit;

import com.oreo.busreservation.domain.Ticket;

import java.lang.reflect.Member;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/ticket/list?member_id={member_id}")
    Call<List<Ticket>> getTicketList(@Path("member_id") int member_id);

    @GET("/ticket/detail?id={id}")
    Call<Ticket> getTicketDetail(@Path("id") int id);

    @GET("/user/login")
    Call<Member> getMember(@Query("userID") String userID, @Query("userPWD") String userPWD);

    @POST("/user/signup")
    Call<Boolean> insertMember(@Query("userID") String userID,
                                         @Query("userPWD") String userPWD,
                                         @Query("name") String name,
                                         @Query("email") String email
                              );
}