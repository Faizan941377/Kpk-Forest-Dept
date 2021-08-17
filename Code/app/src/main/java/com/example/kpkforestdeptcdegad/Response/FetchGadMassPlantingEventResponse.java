package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchGadMassPlantingEventDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchGadMassPlantingEventResponse {


    @SerializedName("users")
    @Expose
    private List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList = null;

    public List<FetchGadMassPlantingEventDataModel> getFetchGadMassPlantingEventDataModelList() {
        return fetchGadMassPlantingEventDataModelList;
    }

    public void setUsers(List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList) {
        this.fetchGadMassPlantingEventDataModelList = fetchGadMassPlantingEventDataModelList;
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
    @SerializedName("name_of_division")
    @Expose
    private String nameOfDivision;
    @SerializedName("chief_guest")
    @Expose
    private String chiefGuest;
    @SerializedName("name_of_event")
    @Expose
    private String nameOfEvent;
    @SerializedName("date_of_event")
    @Expose
    private String dateOfEvent;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("name_of_institute")
    @Expose
    private String nameOfInstitute;
    @SerializedName("no_of_plants_planted")
    @Expose
    private String noOfPlantsPlanted;
    @SerializedName("no_of_plants_distributed")
    @Expose
    private String noOfPlantsDistributed;
    @SerializedName("no_of_plants_utilized")
    @Expose
    private String noOfPlantsUtilized;
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

    public String getNameOfDivision() {
        return nameOfDivision;
    }

    public void setNameOfDivision(String nameOfDivision) {
        this.nameOfDivision = nameOfDivision;
    }

    public String getChiefGuest() {
        return chiefGuest;
    }

    public void setChiefGuest(String chiefGuest) {
        this.chiefGuest = chiefGuest;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNameOfInstitute() {
        return nameOfInstitute;
    }

    public void setNameOfInstitute(String nameOfInstitute) {
        this.nameOfInstitute = nameOfInstitute;
    }

    public String getNoOfPlantsPlanted() {
        return noOfPlantsPlanted;
    }

    public void setNoOfPlantsPlanted(String noOfPlantsPlanted) {
        this.noOfPlantsPlanted = noOfPlantsPlanted;
    }

    public String getNoOfPlantsDistributed() {
        return noOfPlantsDistributed;
    }

    public void setNoOfPlantsDistributed(String noOfPlantsDistributed) {
        this.noOfPlantsDistributed = noOfPlantsDistributed;
    }

    public String getNoOfPlantsUtilized() {
        return noOfPlantsUtilized;
    }

    public void setNoOfPlantsUtilized(String noOfPlantsUtilized) {
        this.noOfPlantsUtilized = noOfPlantsUtilized;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
