package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchVDCDataResponse {

    @SerializedName("users")
    @Expose
    private List<FetchVDCDataModel> vdcData = null;

    public List<FetchVDCDataModel> getVdcData() {
        return vdcData;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name_of_forest_divsion")
    @Expose
    private String nameOfForestDivsion;
    @SerializedName("name_of_sub_division_range")
    @Expose
    private String nameOfSubDivisionRange;
    @SerializedName("name_of_village")
    @Expose
    private String nameOfVillage;
    @SerializedName("name_of_vdc_jfmc")
    @Expose
    private String nameOfVdcJfmc;
    @SerializedName("date_of_establishment_registration")
    @Expose
    private String dateOfEstablishmentRegistration;
    @SerializedName("name_of_president")
    @Expose
    private String nameOfPresident;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("jfmc_wo")
    @Expose
    private String jfmcWo;
    @SerializedName("total_member")
    @Expose
    private String totalMember;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("date_time")
    @Expose
    private String dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfForestDivsion() {
        return nameOfForestDivsion;
    }

    public void setNameOfForestDivsion(String nameOfForestDivsion) {
        this.nameOfForestDivsion = nameOfForestDivsion;
    }

    public String getNameOfSubDivisionRange() {
        return nameOfSubDivisionRange;
    }

    public void setNameOfSubDivisionRange(String nameOfSubDivisionRange) {
        this.nameOfSubDivisionRange = nameOfSubDivisionRange;
    }

    public String getNameOfVillage() {
        return nameOfVillage;
    }

    public void setNameOfVillage(String nameOfVillage) {
        this.nameOfVillage = nameOfVillage;
    }

    public String getNameOfVdcJfmc() {
        return nameOfVdcJfmc;
    }

    public void setNameOfVdcJfmc(String nameOfVdcJfmc) {
        this.nameOfVdcJfmc = nameOfVdcJfmc;
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

    public String getJfmcWo() {
        return jfmcWo;
    }

    public void setJfmcWo(String jfmcWo) {
        this.jfmcWo = jfmcWo;
    }

    public String getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(String totalMember) {
        this.totalMember = totalMember;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}