package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchExtensionMaterialPreparedDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchExtensionMaterialPreparedResponse {


    @SerializedName("users")
    @Expose
    private List<FetchExtensionMaterialPreparedDataModel> fetchExtensionMaterialPreparedDataModelList = null;

    public List<FetchExtensionMaterialPreparedDataModel> getFetchExtensionMaterialPreparedDataModelList() {
        return fetchExtensionMaterialPreparedDataModelList;
    }

    public void setFetchExtensionMaterialPreparedDataModelList(List<FetchExtensionMaterialPreparedDataModel> fetchExtensionMaterialPreparedDataModelList) {
        this.fetchExtensionMaterialPreparedDataModelList = fetchExtensionMaterialPreparedDataModelList;
    }


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Souvenirs_Shields_No")
    @Expose
    private String souvenirsShieldsNo;
    @SerializedName("no_of_panaflex")
    @Expose
    private String noOfPanaflex;
    @SerializedName("square_feet")
    @Expose
    private String squareFeet;
    @SerializedName("month_of_preparation")
    @Expose
    private String monthOfPreparation;
    @SerializedName("no_of_diaries")
    @Expose
    private String noOfDiaries;
    @SerializedName("no_of_calenders")
    @Expose
    private String noOfCalenders;
    @SerializedName("banners")
    @Expose
    private String banners;
    @SerializedName("action_plan")
    @Expose
    private String actionPlan;
    @SerializedName("key_chain")
    @Expose
    private String keyChain;
    @SerializedName("no_of_miscellaneous_extension_material")
    @Expose
    private String noOfMiscellaneousExtensionMaterial;
    @SerializedName("time_date")
    @Expose
    private String timeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSouvenirsShieldsNo() {
        return souvenirsShieldsNo;
    }

    public void setSouvenirsShieldsNo(String souvenirsShieldsNo) {
        this.souvenirsShieldsNo = souvenirsShieldsNo;
    }

    public String getNoOfPanaflex() {
        return noOfPanaflex;
    }

    public void setNoOfPanaflex(String noOfPanaflex) {
        this.noOfPanaflex = noOfPanaflex;
    }

    public String getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(String squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getMonthOfPreparation() {
        return monthOfPreparation;
    }

    public void setMonthOfPreparation(String monthOfPreparation) {
        this.monthOfPreparation = monthOfPreparation;
    }

    public String getNoOfDiaries() {
        return noOfDiaries;
    }

    public void setNoOfDiaries(String noOfDiaries) {
        this.noOfDiaries = noOfDiaries;
    }

    public String getNoOfCalenders() {
        return noOfCalenders;
    }

    public void setNoOfCalenders(String noOfCalenders) {
        this.noOfCalenders = noOfCalenders;
    }

    public String getBanners() {
        return banners;
    }

    public void setBanners(String banners) {
        this.banners = banners;
    }

    public String getActionPlan() {
        return actionPlan;
    }

    public void setActionPlan(String actionPlan) {
        this.actionPlan = actionPlan;
    }

    public String getKeyChain() {
        return keyChain;
    }

    public void setKeyChain(String keyChain) {
        this.keyChain = keyChain;
    }

    public String getNoOfMiscellaneousExtensionMaterial() {
        return noOfMiscellaneousExtensionMaterial;
    }

    public void setNoOfMiscellaneousExtensionMaterial(String noOfMiscellaneousExtensionMaterial) {
        this.noOfMiscellaneousExtensionMaterial = noOfMiscellaneousExtensionMaterial;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

}
