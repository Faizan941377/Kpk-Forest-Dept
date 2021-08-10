package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchJFMCDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchJFMCDataResponse {

    @SerializedName("users")
    @Expose
    private List<FetchJFMCDataModel> fetchJFMCDataModelList = null;

    public List<FetchJFMCDataModel> getFetchJFMCDataModelList() {
        return fetchJFMCDataModelList;
    }

    public void setFetchJFMCDataModelList(List<FetchJFMCDataModel> fetchJFMCDataModelList) {
        this.fetchJFMCDataModelList = fetchJFMCDataModelList;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_no")
    @Expose
    private String employeeNo;
    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("name_of_forest_division")
    @Expose
    private String nameOfForestDivision;
    @SerializedName("name_of_sub_division_range")
    @Expose
    private String nameOfSubDivisionRange;
    @SerializedName("name_of_village_vdc")
    @Expose
    private String nameOfVillageVdc;
    @SerializedName("name_of_jfmc")
    @Expose
    private String nameOfJfmc;
    @SerializedName("date_of_establishment_registration")
    @Expose
    private String dateOfEstablishmentRegistration;
    @SerializedName("name_of_president")
    @Expose
    private String nameOfPresident;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("time_date")
    @Expose
    private String timeDate;

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

    public String getNameOfForestDivision() {
        return nameOfForestDivision;
    }

    public void setNameOfForestDivision(String nameOfForestDivision) {
        this.nameOfForestDivision = nameOfForestDivision;
    }

    public String getNameOfSubDivisionRange() {
        return nameOfSubDivisionRange;
    }

    public void setNameOfSubDivisionRange(String nameOfSubDivisionRange) {
        this.nameOfSubDivisionRange = nameOfSubDivisionRange;
    }

    public String getNameOfVillageVdc() {
        return nameOfVillageVdc;
    }

    public void setNameOfVillageVdc(String nameOfVillageVdc) {
        this.nameOfVillageVdc = nameOfVillageVdc;
    }

    public String getNameOfJfmc() {
        return nameOfJfmc;
    }

    public void setNameOfJfmc(String nameOfJfmc) {
        this.nameOfJfmc = nameOfJfmc;
    }

    public String getDateOfEstablishmentRegistration() {
        return dateOfEstablishmentRegistration;
    }

    public void setDateOfEstablishmentRegistration(String dateOfEstablishmentRegistration) {
        this.dateOfEstablishmentRegistration = dateOfEstablishmentRegistration;
    }

    public String getNameOfPresident() {
        return nameOfPresident;
    }

    public void setNameOfPresident(String nameOfPresident) {
        this.nameOfPresident = nameOfPresident;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

}