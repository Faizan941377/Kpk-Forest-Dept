package com.example.kpkforestdeptcdegad.Network;


import com.example.kpkforestdeptcdegad.Model.FetchEnclosureDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchExtensionMaterialPreparedDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchWaterHarvestingSchemeDataModel;
import com.example.kpkforestdeptcdegad.Response.CD_JFMCResponse;
import com.example.kpkforestdeptcdegad.Response.CelebrationOfEnvironmentalPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.EnclosureResponse;
import com.example.kpkforestdeptcdegad.Response.ExtensionMaterialPreparedResponse;
import com.example.kpkforestdeptcdegad.Response.FarmAgroForestryResponse;
import com.example.kpkforestdeptcdegad.Response.FarmForestryResponse;
import com.example.kpkforestdeptcdegad.Response.FetchCelebrationOfEnvironmentalPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.FetchEnclosureResponse;
import com.example.kpkforestdeptcdegad.Response.FetchExtensionMaterialPreparedResponse;
import com.example.kpkforestdeptcdegad.Response.FetchFarmAgroForestryResponse;
import com.example.kpkforestdeptcdegad.Response.FetchFarmForestryResponse;
import com.example.kpkforestdeptcdegad.Response.FetchGadMassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.FetchJFMCDataResponse;
import com.example.kpkforestdeptcdegad.Response.FetchMassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.FetchOtherActivityResponse;
import com.example.kpkforestdeptcdegad.Response.FetchVDCDataResponse;
import com.example.kpkforestdeptcdegad.Response.FetchWaterHarvestingSchemeResponse;
import com.example.kpkforestdeptcdegad.Response.FetchWaterSourceDevelopSchemeResponse;
import com.example.kpkforestdeptcdegad.Response.FetchWomenOrganizationResponse;
import com.example.kpkforestdeptcdegad.Response.FetchYouthWomenNurseryResponse;
import com.example.kpkforestdeptcdegad.Response.GadMassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.LoginResponse;
import com.example.kpkforestdeptcdegad.Response.MassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.Response.OtherActivityResponse;
import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.example.kpkforestdeptcdegad.Response.VDCResponse;
import com.example.kpkforestdeptcdegad.Response.WaterHarvestingSchemeResponse;
import com.example.kpkforestdeptcdegad.Response.WaterSourceDevelopmentSchemeResponse;
import com.example.kpkforestdeptcdegad.Response.WomenOrganizationResponse;
import com.example.kpkforestdeptcdegad.Response.YouthWomenNurseryResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Webservices {

    @FormUrlEncoded
    @POST("cd_vdc.php")
    Call<VDCResponse> vdcInsert(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
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
    Call<CD_JFMCResponse> jfmcInsert(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
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
            @Field("full_name") String full_name,
            @Field("gender") String gender,
            @Field("cnic") String cnic,
            @Field("employee_no") String employee_no,
            @Field("mobile") String mobile,
            @Field("division") String division,
            @Field("email") String email,
            @Field("password") String password,
            @Field("image") String image
    );

    @GET("fetchAllUsers.php")
    Call<LoginResponse> loginResponse();

    @FormUrlEncoded
    @POST("cd_enclosure.php")
    Call<EnclosureResponse> enclosure(
            @Field("employee_No") String employee_No,
            @Field("employee_Name") String employee_Name,
            @Field("forest_division") String forest_division,
            @Field("entry_date") String entry_date,
            @Field("target_as_pc_1_enclosure") String target_as_pc_1_enclosure,
            @Field("site_for_enclosure_achieved") String site_for_enclosure_achieved,
            @Field("vdc_established") String vdc_established,
            @Field("nigehbans_hired") String nigehbans_hired,
            @Field("payment_upto") String payment_upto,
            @Field("balance_target") String balance_target,
            @Field("remarks") String remarks
    );


    @GET("fetchEnclosureData.php")
    Call<FetchEnclosureResponse> fetchEnclosureResponse();


    @FormUrlEncoded
    @POST("cd_farm_forestry.php")
    Call<FarmForestryResponse> farmForestry(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_forest_division") String name_of_forest_division,
            @Field("name_of_sub_division") String name_of_sub_division,
            @Field("plants_distributed_today") String plants_distributed_today,
            @Field("total_no_of_plants_distributed_today") String total_no_of_plants_distributed_today,
            @Field("total_no_of_plants_distribute_till_date") String total_no_of_plants_distribute_till_date
    );

    @GET("fetchCDFARMFORESTY.php")
    Call<FetchFarmForestryResponse> fetchFarmForestryResponse();


    @FormUrlEncoded
    @POST("cd_waterHarvestingScheme.php")
    Call<WaterHarvestingSchemeResponse> waterHarvestingResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_division") String name_of_division,
            @Field("name_of_forest_division") String name_of_forest_division,
            @Field("target_as_pc1") String target_as_pc1,
            @Field("achieved_so_far_no") String achieved_so_far_no,
            @Field("vdc_established") String vdc_established,
            @Field("progress_till_date") String progress_till_date
    );

    @GET("fetchCDWaterHarvestingSchemeData.php")
    Call<FetchWaterHarvestingSchemeResponse> fetchWaterHarvestingResponse();


    @FormUrlEncoded
    @POST("cd_waterSourceDevelopmentScheme.php")
    Call<WaterSourceDevelopmentSchemeResponse> waterSourceDevelopmentSchemeResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_division") String name_of_division,
            @Field("name_of_forest_division") String name_of_forest_division,
            @Field("target_as_pc_1") String target_as_pc_1,
            @Field("achieved_so_far_no") String achieved_so_far_no,
            @Field("vdc_established") String vdc_established,
            @Field("progress_till_date") String progress_till_date
    );

    @GET("fetchCDWaterSourceDevelopmentScheme.php")
    Call<FetchWaterSourceDevelopSchemeResponse> fetchWaterSourceDevelopSchemeResponse();

    @FormUrlEncoded
    @POST("extension_Mass_Planting_Event.php")
    Call<MassPlantingEventResponse> massPlantingEventResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("location_venu") String location_venu,
            @Field("chief_guest") String chief_guest,
            @Field("date_of_event") String date_of_event,
            @Field("no_of_plants_planted") String no_of_plants_planted,
            @Field("no_of_plants_distributed") String no_of_plants_distributed,
            @Field("spring_moon_soon") String spring_moon_soon,
            @Field("total_no_of_plants") String total_no_of_plants
    );

    @GET("fetchExtensionMassPlantingEvent.php")
    Call<FetchMassPlantingEventResponse> fetchMassPlantingEventResponse();

    @FormUrlEncoded
    @POST("extension_Celebration_Environmental_Planting_Events.php")
    Call<CelebrationOfEnvironmentalPlantingEventResponse> celebrationOfEnvironmentalPlantingEventResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("location_of_event_name_of_institute") String location_of_event_name_of_institute,
            @Field("chief_guest") String chief_guest,
            @Field("environmental_planting_type") String environmental_planting_type,
            @Field("environmental_day_planting_event") String environmental_day_planting_event,
            @Field("date_of_event") String date_of_event,
            @Field("no_of_planted") String no_of_planted
    );

    @GET("fetchExtensionCelebrationEnvironmentalPlantingEvent.php")
    Call<FetchCelebrationOfEnvironmentalPlantingEventResponse> fetchCelebrationOfEnvironmentalPlantingEvent();


    @FormUrlEncoded
    @POST("extension_Material_Prepared.php")
    Call<ExtensionMaterialPreparedResponse> extensionMaterialPreparedResponse(
            @Field("Souvenirs_Shields_No") String Souvenirs_Shields_No,
            @Field("no_of_panaflex") String no_of_panaflex,
            @Field("square_feet") String square_feet,
            @Field("month_of_preparation") String month_of_preparation,
            @Field("no_of_diaries") String no_of_diaries,
            @Field("no_of_calenders") String no_of_calenders,
            @Field("banners") String banners,
            @Field("action_plan") String action_plan,
            @Field("key_chain") String key_chain,
            @Field("no_of_miscellaneous_extension_material") String no_of_miscellaneous_extension_material
    );

    @GET("fetchExtensionMaterialPrepared.php")
    Call<FetchExtensionMaterialPreparedResponse> fetchExtensionMaterialPreparedResponse();


    @FormUrlEncoded
    @POST("GADWomenOrganization.php")
    Call<WomenOrganizationResponse> womenOrganizationResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_village_vdc") String name_of_village_vdc,
            @Field("name_of_wo") String name_of_wo,
            @Field("date_year_of_establishment") String date_year_of_establishment,
            @Field("name_of_president") String name_of_president,
            @Field("mojor_activities") String mojor_activities,
            @Field("total_member") String total_member,
            @Field("contact") String contact,
            @Field("remarks") String remarks,
            @Field("image") String image
    );

    @GET("fetchGADWomenOrganization.php")
    Call<FetchWomenOrganizationResponse> fetchWomenOrganizationResponse();


    @FormUrlEncoded
    @POST("GADYouth_women_nursery.php")
    Call<YouthWomenNurseryResponse> youthWomenNurseryResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_division") String name_of_division,
            @Field("name_of_sub_division_range") String name_of_sub_division_range,
            @Field("vdc_wo") String vdc_wo,
            @Field("name_of_nursery_owner") String name_of_nursery_owner,
            @Field("location_village_name") String location_village_name,
            @Field("limits") String limits
    );

    @GET("fetchYouthWomenNursery.php")
    Call<FetchYouthWomenNurseryResponse> fetchYouthWomenNurseryResponse();


    @FormUrlEncoded
    @POST("GADMassPlantingEvent.php")
    Call<GadMassPlantingEventResponse> gadMassPlantingEventResponse(

            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("name_of_division") String name_of_division,
            @Field("chief_guest") String chief_guest,
            @Field("name_of_event") String name_of_event,
            @Field("date_of_event") String date_of_event,
            @Field("location") String location,
            @Field("name_of_institute") String name_of_institute,
            @Field("no_of_plants_planted") String no_of_plants_planted,
            @Field("no_of_plants_distributed") String no_of_plants_distributed,
            @Field("no_of_plants_utilized") String no_of_plants_utilized
    );

    @GET("fetchGadMassPlantingEvent.php")
    Call<FetchGadMassPlantingEventResponse> fetchGadMassPlantingEventResponse();


    @FormUrlEncoded
    @POST("GADFarmAgroForestry.php")
    Call<FarmAgroForestryResponse> farmAgroForestryResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("gad_add") String gad_add,
            @Field("other_activities") String other_activities,
            @Field("name_of_women_organization") String name_of_women_organization,
            @Field("name_of_major_activities") String name_of_major_activities,
            @Field("name_of_village") String name_of_village
    );


    @GET("fetchGADFarmAgroForestry.php")
    Call<FetchFarmAgroForestryResponse> fetchFarmAgroForestryResponse();


    @FormUrlEncoded
    @POST("GADOtherActivity.php")
    Call<OtherActivityResponse> otherActivityResponse(
            @Field("employee_no") String employee_no,
            @Field("employee_name") String employee_name,
            @Field("activity_title") String activity_title,
            @Field("name_of_forest_division") String name_of_forest_division,
            @Field("name_of_wo") String name_of_wo,
            @Field("name_of_village") String name_of_village,
            @Field("description") String description
    );


    @GET("fetchGADOtherActivity.php")
    Call<FetchOtherActivityResponse> fetchOtherActivityResponse();
}
