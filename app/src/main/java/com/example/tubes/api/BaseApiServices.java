package com.example.tubes.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiServices {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@Field("email") String email,
                             @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> addRegisterData(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

}
