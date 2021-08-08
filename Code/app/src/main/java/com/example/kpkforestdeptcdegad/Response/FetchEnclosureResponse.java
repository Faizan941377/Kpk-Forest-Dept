package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchEnclosureDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchEnclosureResponse {

    @SerializedName("users")
    @Expose
    private List<FetchEnclosureDataModel> fetchEnclosureDataModelList = null;

    public List<FetchEnclosureDataModel> getFetchEnclosureDataModelList() {
        return fetchEnclosureDataModelList;
    }

    public void setFetchEnclosureDataModelList(List<FetchEnclosureDataModel> fetchEnclosureDataModelList) {
        this.fetchEnclosureDataModelList = fetchEnclosureDataModelList;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_No")
    @Expose
    private String employeeNo;
    @SerializedName("forest_division")
    @Expose
    private String forestDivision;
    @SerializedName("entry_date")
    @Expose
    private String entryDate;
    @SerializedName("target_as_pc_1_enclosure")
    @Expose
    private String targetAsPc1Enclosure;
    @SerializedName("site_for_enclosure_achieved")
    @Expose
    private String siteForEnclosureAchieved;
    @SerializedName("vdc_established")
    @Expose
    private String vdcEstablished;
    @SerializedName("nigehbans_hired")
    @Expose
    private String nigehbansHired;
    @SerializedName("payment_upto")
    @Expose
    private String paymentUpto;
    @SerializedName("balance_target")
    @Expose
    private String balanceTarget;
    @SerializedName("remarks")
    @Expose
    private String remarks;
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

    public String getForestDivision() {
        return forestDivision;
    }

    public void setForestDivision(String forestDivision) {
        this.forestDivision = forestDivision;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getTargetAsPc1Enclosure() {
        return targetAsPc1Enclosure;
    }

    public void setTargetAsPc1Enclosure(String targetAsPc1Enclosure) {
        this.targetAsPc1Enclosure = targetAsPc1Enclosure;
    }

    public String getSiteForEnclosureAchieved() {
        return siteForEnclosureAchieved;
    }

    public void setSiteForEnclosureAchieved(String siteForEnclosureAchieved) {
        this.siteForEnclosureAchieved = siteForEnclosureAchieved;
    }

    public String getVdcEstablished() {
        return vdcEstablished;
    }

    public void setVdcEstablished(String vdcEstablished) {
        this.vdcEstablished = vdcEstablished;
    }

    public String getNigehbansHired() {
        return nigehbansHired;
    }

    public void setNigehbansHired(String nigehbansHired) {
        this.nigehbansHired = nigehbansHired;
    }

    public String getPaymentUpto() {
        return paymentUpto;
    }

    public void setPaymentUpto(String paymentUpto) {
        this.paymentUpto = paymentUpto;
    }

    public String getBalanceTarget() {
        return balanceTarget;
    }

    public void setBalanceTarget(String balanceTarget) {
        this.balanceTarget = balanceTarget;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
