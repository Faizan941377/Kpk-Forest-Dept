package com.example.kpkforestdeptcdegad.Model;

public class FetchEnclosureDataModel {

    String employee_No;
    String forest_division;
    String entry_date;
    String target_as_pc_1_enclosure;
    String site_for_enclosure_achieved;
    String vdc_established;
    String nigehbans_hired;
    String payment_upto;
    String balance_target;
    String remarks;
    String date_time;

    public FetchEnclosureDataModel(String employee_No, String forest_division, String entry_date, String target_as_pc_1_enclosure,
                                   String site_for_enclosure_achieved, String vdc_established, String nigehbans_hired,
                                   String payment_upto, String balance_target, String remarks, String date_time) {
        this.employee_No = employee_No;
        this.forest_division = forest_division;
        this.entry_date = entry_date;
        this.target_as_pc_1_enclosure = target_as_pc_1_enclosure;
        this.site_for_enclosure_achieved = site_for_enclosure_achieved;
        this.vdc_established = vdc_established;
        this.nigehbans_hired = nigehbans_hired;
        this.payment_upto = payment_upto;
        this.balance_target = balance_target;
        this.remarks = remarks;
        this.date_time = date_time;
    }

    public String getEmployee_No() {
        return employee_No;
    }

    public void setEmployee_No(String employee_No) {
        this.employee_No = employee_No;
    }

    public String getForest_division() {
        return forest_division;
    }

    public void setForest_division(String forest_division) {
        this.forest_division = forest_division;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getTarget_as_pc_1_enclosure() {
        return target_as_pc_1_enclosure;
    }

    public void setTarget_as_pc_1_enclosure(String target_as_pc_1_enclosure) {
        this.target_as_pc_1_enclosure = target_as_pc_1_enclosure;
    }

    public String getSite_for_enclosure_achieved() {
        return site_for_enclosure_achieved;
    }

    public void setSite_for_enclosure_achieved(String site_for_enclosure_achieved) {
        this.site_for_enclosure_achieved = site_for_enclosure_achieved;
    }

    public String getVdc_established() {
        return vdc_established;
    }

    public void setVdc_established(String vdc_established) {
        this.vdc_established = vdc_established;
    }

    public String getNigehbans_hired() {
        return nigehbans_hired;
    }

    public void setNigehbans_hired(String nigehbans_hired) {
        this.nigehbans_hired = nigehbans_hired;
    }

    public String getPayment_upto() {
        return payment_upto;
    }

    public void setPayment_upto(String payment_upto) {
        this.payment_upto = payment_upto;
    }

    public String getBalance_target() {
        return balance_target;
    }

    public void setBalance_target(String balance_target) {
        this.balance_target = balance_target;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTime_date() {
        return date_time;
    }

    public void setTime_date(String date_time) {
        this.date_time = date_time;
    }
}
