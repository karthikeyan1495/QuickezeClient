package com.star.quickezeclient.api;

import com.star.quickezeclient.allservice.modal.AllserviceModal;
import com.star.quickezeclient.login.modal.Loginmodal;

import io.reactivex.Observable;
import retrofit2.Response;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCall {

    @POST("send_client_otp")
    Observable<Response<GeneralResponse>> login(@Body Loginmodal loginmodal);

    @POST("client_otp_verify")
    Observable<Response<GeneralResponse>> otpsend(@Body Loginmodal loginmodal);


    @GET("services")
    Observable<Response<AllserviceModal>> allservice();





}
