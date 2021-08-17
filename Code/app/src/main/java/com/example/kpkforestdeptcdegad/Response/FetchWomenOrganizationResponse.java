package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchWomenOrganizationDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchWomenOrganizationResponse {


    @SerializedName("users")
    @Expose
    private List<FetchWomenOrganizationDataModel> fetchWomenOrganizationDataModelList = null;

    public List<FetchWomenOrganizationDataModel> getFetchWomenOrganizationDataModelList() {
        return fetchWomenOrganizationDataModelList;
    }

    public void setFetchWomenOrganizationDataModelList(List<FetchWomenOrganizationDataModel> fetchWomenOrganizationDataModelList) {
        this.fetchWomenOrganizationDataModelList = fetchWomenOrganizationDataModelList;
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
    @SerializedName("name_of_village_vdc")
    @Expose
    private String nameOfVillageVdc;
    @SerializedName("name_of_wo")
    @Expose
    private String nameOfWo;
    @SerializedName("date_year_of_establishment")
    @Expose
    private String dateYearOfEstablishment;
    @SerializedName("name_of_president")
    @Expose
    private String nameOfPresident;
    @SerializedName("mojor_activities")
    @Expose
    private String mojorActivities;
    @SerializedName("total_member")
    @Expose
    private String totalMember;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("remarks")
    @Expose
    private String remarks;
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

    public String getNameOfVillageVdc() {
        return nameOfVillageVdc;
    }

    public void setNameOfVillageVdc(String nameOfVillageVdc) {
        this.nameOfVillageVdc = nameOfVillageVdc;
    }

    public String getNameOfWo() {
        return nameOfWo;
    }

    public void setNameOfWo(String nameOfWo) {
        this.nameOfWo = nameOfWo;
    }

    public String getDateYearOfEstablishment() {
        return dateYearOfEstablishment;
    }

    public void setDateYearOfEstablishment(String dateYearOfEstablishment) {
        this.dateYearOfEstablishment = dateYearOfEstablishment;
    }

    public String getNameOfPresident() {
        return nameOfPresident;
    }

    public void setNameOfPresident(String nameOfPresident) {
        this.nameOfPresident = nameOfPresident;
    }

    public String getMojorActivities() {
        return mojorActivities;
    }

    public void setMojorActivities(String mojorActivities) {
        this.mojorActivities = mojorActivities;
    }

    public String getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(String totalMember) {
        this.totalMember = totalMember;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

}
