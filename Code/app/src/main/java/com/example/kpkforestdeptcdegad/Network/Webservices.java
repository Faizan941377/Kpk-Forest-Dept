package com.example.kpkforestdeptcdegad.Network;


import com.example.kpkforestdeptcdegad.Response.CD_JFMCResponse;
import com.example.kpkforestdeptcdegad.Response.FetchJFMCDataResponse;
import com.example.kpkforestdeptcdegad.Response.FetchVDCDataResponse;
import com.example.kpkforestdeptcdegad.Response.LoginResponse;
import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.example.kpkforestdeptcdegad.Response.VDCResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Webservices {

    @FormUrlEncoded
    @POST("cd_vdc.php")
    Call<VDCResponse> vdcInsert(
            @Field("name_of_forest_divsion") String name_of_forest_divsion,
            @Field("name_of_sub_division_range") String name_of_sub_division_range,
            @Field("name_of_village") String name_of_village,
            @Field("name_of_vdc_jfmc") String name_of_vdc_jfmc,
            @Field("date_of_establishment_registration") String date_of_establishment_registration,
            @Field("name_of_president") String name_of_president,
            @Field("contact") String contact,
            @Field("jfmc_wo") String jfmc_wo,
            @Field("total_member") String total_member,
            @Field("image") String image
    );

    @GET("fetchCDVdcData.php")
    Call<FetchVDCDataResponse> fetchVdcDataResponse();

    @FormUrlEncoded
    @POST("cd_jfmc.php")
    Call <CD_JFMCResponse> jfmcInsert(
            @Field("name_of_forest_division") String name_of_forest_division,
            @Field("name_of_sub_division_range") String name_of_sub_division_range,
            @Field("name_of_village_vdc") String name_of_village_vdc,
            @Field("name_of_jfmc") String name_of_jfmc,
            @Field("date_of_establishment_registration") String date_of_establishment_registration,
            @Field("name_of_president") String name_of_president,
            @Field("contact") String contact
    );

    @GET("fetchCDJFMCData.php")
    Call<FetchJFMCDataResponse> fetchJFMCDataResponse();

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
        @Field("email") String email,
        @Field("password") String password
        );

    @FormUrlEncoded
    @POST("register.php")
    Call<RegistrationResponse> register(
            @Field("full_name") String  full_name,
            @Field("gender") String gender,
            @Field("cnic") String cnic,
            @Field("employee_no") String employee_no,
            @Field("mobile") String mobile,
            @Field("division") String division,
            @Field("email") String email,
            @Field("password") String password,
            @Field("image") String image
    );
}
