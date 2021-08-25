package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchFarmAgroForestryDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchFarmAgroForestryResponse {

    @SerializedName("users")
    @Expose
    private List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList = null;

    public List<FetchFarmAgroForestryDataModel> getFetchFarmAgroForestryDataModelList() {
        return fetchFarmAgroForestryDataModelList;
    }

    public void setFetchFarmAgroForestryDataModelList(List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList){
        this.fetchFarmAgroForestryDataModelList = fetchFarmAgroForestryDataModelList;
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
    @SerializedName("gad_add")
    @Expose
    private String gadAdd;
    @SerializedName("other_activities")
    @Expose
    private String otherActivities;
    @SerializedName("name_of_women_organization")
    @Expose
    private String nameOfWomenOrganization;
    @SerializedName("name_of_major_activities")
    @Expose
    private String nameOfMajorActivities;
    @SerializedName("name_of_village")
    @Expose
    private String nameOfVillage;
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

    public String getGadAdd() {
        return gadAdd;
    }

    public void setGadAdd(String gadAdd) {
        this.gadAdd = gadAdd;
    }

    public String getOtherActivities() {
        return otherActivities;
    }

    public void setOtherActivities(String otherActivities) {
        this.otherActivities = otherActivities;
    }

    public String getNameOfWomenOrganization() {
        return nameOfWomenOrganization;
    }

    public void setNameOfWomenOrganization(String nameOfWomenOrganization) {
        this.nameOfWomenOrganization = nameOfWomenOrganization;
    }

    public String getNameOfMajorActivities() {
        return nameOfMajorActivities;
    }

    public void setNameOfMajorActivities(String nameOfMajorActivities) {
        this.nameOfMajorActivities = nameOfMajorActivities;
    }

    public String getNameOfVillage() {
        return nameOfVillage;
    }

    public void setNameOfVillage(String nameOfVillage) {
        this.nameOfVillage = nameOfVillage;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
