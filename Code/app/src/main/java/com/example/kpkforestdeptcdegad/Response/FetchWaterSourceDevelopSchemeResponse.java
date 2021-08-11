package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchWaterSourceDevelopSchemeDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchWaterSourceDevelopSchemeResponse {


    @SerializedName("users")
    @Expose
    private List<FetchWaterSourceDevelopSchemeDataModel> fetchWaterSourceDevelopSchemeDataModelList = null;

    public List<FetchWaterSourceDevelopSchemeDataModel> getFetchWaterSourceDevelopSchemeDataModelList() {
        return fetchWaterSourceDevelopSchemeDataModelList;
    }

    public void setFetchWaterSourceDevelopSchemeDataModelList(List<FetchWaterSourceDevelopSchemeDataModel> fetchWaterSourceDevelopSchemeDataModelList) {
        this.fetchWaterSourceDevelopSchemeDataModelList = fetchWaterSourceDevelopSchemeDataModelList;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_No")
    @Expose
    private String employeeNo;
    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("name_of_division")
    @Expose
    private String nameOfDivision;
    @SerializedName("name_of_forest_division")
    @Expose
    private String nameOfForestDivision;
    @SerializedName("target_as_pc_1")
    @Expose
    private String targetAsPc1;
    @SerializedName("achieved_so_far_no")
    @Expose
    private String achievedSoFarNo;
    @SerializedName("vdc_established")
    @Expose
    private String vdcEstablished;
    @SerializedName("progress_till_date")
    @Expose
    private String progressTillDate;
    @SerializedName("date_time")
    @Expose
    private String dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getNameOfDivision() {
        return nameOfDivision;
    }

    public void setNameOfDivision(String nameOfDivision) {
        this.nameOfDivision = nameOfDivision;
    }

    public String getNameOfForestDivision() {
        return nameOfForestDivision;
    }

    public void setNameOfForestDivision(String nameOfForestDivision) {
        this.nameOfForestDivision = nameOfForestDivision;
    }

    public String getTargetAsPc1() {
        return targetAsPc1;
    }

    public void setTargetAsPc1(String targetAsPc1) {
        this.targetAsPc1 = targetAsPc1;
    }

    public String getAchievedSoFarNo() {
        return achievedSoFarNo;
    }

    public void setAchievedSoFarNo(String achievedSoFarNo) {
        this.achievedSoFarNo = achievedSoFarNo;
    }

    public String getVdcEstablished() {
        return vdcEstablished;
    }

    public void setVdcEstablished(String vdcEstablished) {
        this.vdcEstablished = vdcEstablished;
    }

    public String getProgressTillDate() {
        return progressTillDate;
    }

    public void setProgressTillDate(String progressTillDate) {
        this.progressTillDate = progressTillDate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}