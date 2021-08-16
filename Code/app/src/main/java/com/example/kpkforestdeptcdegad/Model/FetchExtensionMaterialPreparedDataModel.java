package com.example.kpkforestdeptcdegad.Model;

public class FetchExtensionMaterialPreparedDataModel {

    String Souvenirs_Shields_No;
    String no_of_panaflex;
    String square_feet;
    String month_of_preparation;
    String no_of_diaries;
    String no_of_calenders;
    String banners;
    String action_plan;
    String key_chain;
    String no_of_miscellaneous_extension_material;
    String time_date;

    public FetchExtensionMaterialPreparedDataModel(String souvenirs_Shields_No, String no_of_panaflex, String square_feet,
                                                   String month_of_preparation, String no_of_diaries,
                                                   String no_of_calenders, String banners, String action_plan,
                                                   String key_chain, String no_of_miscellaneous_extension_material,
                                                   String time_date) {
        Souvenirs_Shields_No = souvenirs_Shields_No;
        this.no_of_panaflex = no_of_panaflex;
        this.square_feet = square_feet;
        this.month_of_preparation = month_of_preparation;
        this.no_of_diaries = no_of_diaries;
        this.no_of_calenders = no_of_calenders;
        this.banners = banners;
        this.action_plan = action_plan;
        this.key_chain = key_chain;
        this.no_of_miscellaneous_extension_material = no_of_miscellaneous_extension_material;
        this.time_date = time_date;
    }

    public String getSouvenirs_Shields_No() {
        return Souvenirs_Shields_No;
    }

    public void setSouvenirs_Shields_No(String souvenirs_Shields_No) {
        Souvenirs_Shields_No = souvenirs_Shields_No;
    }

    public String getNo_of_panaflex() {
        return no_of_panaflex;
    }

    public void setNo_of_panaflex(String no_of_panaflex) {
        this.no_of_panaflex = no_of_panaflex;
    }

    public String getSquare_feet() {
        return square_feet;
    }

    public void setSquare_feet(String square_feet) {
        this.square_feet = square_feet;
    }

    public String getMonth_of_preparation() {
        return month_of_preparation;
    }

    public void setMonth_of_preparation(String month_of_preparation) {
        this.month_of_preparation = month_of_preparation;
    }

    public String getNo_of_diaries() {
        return no_of_diaries;
    }

    public void setNo_of_diaries(String no_of_diaries) {
        this.no_of_diaries = no_of_diaries;
    }

    public String getNo_of_calenders() {
        return no_of_calenders;
    }

    public void setNo_of_calenders(String no_of_calenders) {
        this.no_of_calenders = no_of_calenders;
    }

    public String getBanners() {
        return banners;
    }

    public void setBanners(String banners) {
        this.banners = banners;
    }

    public String getAction_plan() {
        return action_plan;
    }

    public void setAction_plan(String action_plan) {
        this.action_plan = action_plan;
    }

    public String getKey_chain() {
        return key_chain;
    }

    public void setKey_chain(String key_chain) {
        this.key_chain = key_chain;
    }

    public String getNo_of_miscellaneous_extension_material() {
        return no_of_miscellaneous_extension_material;
    }

    public void setNo_of_miscellaneous_extension_material(String no_of_miscellaneous_extension_material) {
        this.no_of_miscellaneous_extension_material = no_of_miscellaneous_extension_material;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
