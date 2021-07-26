package com.example.kpkforestdeptcdegad.Network;


import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.example.kpkforestdeptcdegad.Response.VDC;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Webservices {

    @FormUrlEncoded
    @POST("vdc.php")
    Call<VDC> vdcInsert(
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
}
