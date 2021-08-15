package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchCelebrationOfEnvironmentalPlantingEventDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchCelebrationOfEnvironmentalPlantingEventResponse {


    @SerializedName("users")
    @Expose
    private List<FetchCelebrationOfEnvironmentalPlantingEventDataModel>
            fetchCelebrationOfEnvironmentalPlantingEventDataModelList = null;

    public List<FetchCelebrationOfEnvironmentalPlantingEventDataModel>
    getFetchCelebrationOfEnvironmentalPlantingEventDataModelList() {
        return fetchCelebrationOfEnvironmentalPlantingEventDataModelList;
    }

    public void setFetchCelebrationOfEnvironmentalPlantingEventDataModelList(List<FetchCelebrationOfEnvironmentalPlantingEventDataModel>
                                                                                     fetchCelebrationOfEnvironmentalPlantingEventDataModelList) {
        this.fetchCelebrationOfEnvironmentalPlantingEventDataModelList = fetchCelebrationOfEnvironmentalPlantingEventDataModelList;
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
    @SerializedName("location_of_event_name_of_institute")
    @Expose
    private String locationOfEventNameOfInstitute;
    @SerializedName("chief_guest")
    @Expose
    private String chiefGuest;
    @SerializedName("environmental_planting_type")
    @Expose
    private String environmentalPlantingType;
    @SerializedName("environmental_day_planting_event")
    @Expose
    private String environmentalDayPlantingEvent;
    @SerializedName("date_of_event")
    @Expose
    private String dateOfEvent;
    @SerializedName("no_of_planted")
    @Expose
    private String noOfPlanted;
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

    public String getLocationOfEventNameOfInstitute() {
        return locationOfEventNameOfInstitute;
    }

    public void setLocationOfEventNameOfInstitute(String locationOfEventNameOfInstitute) {
        this.locationOfEventNameOfInstitute = locationOfEventNameOfInstitute;
    }

    public String getChiefGuest() {
        return chiefGuest;
    }

    public void setChiefGuest(String chiefGuest) {
        this.chiefGuest = chiefGuest;
    }

    public String getEnvironmentalPlantingType() {
        return environmentalPlantingType;
    }

    public void setEnvironmentalPlantingType(String environmentalPlantingType) {
        this.environmentalPlantingType = environmentalPlantingType;
    }

    public String getEnvironmentalDayPlantingEvent() {
        return environmentalDayPlantingEvent;
    }

    public void setEnvironmentalDayPlantingEvent(String environmentalDayPlantingEvent) {
        this.environmentalDayPlantingEvent = environmentalDayPlantingEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getNoOfPlanted() {
        return noOfPlanted;
    }

    public void setNoOfPlanted(String noOfPlanted) {
        this.noOfPlanted = noOfPlanted;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

}
