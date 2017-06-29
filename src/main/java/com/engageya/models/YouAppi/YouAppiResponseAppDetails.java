package com.engageya.models.YouAppi;

/**
 * Created by LIOR on 26/06/2017.
 */
public class YouAppiResponseAppDetails {
    private String app_id;
    private String app_icon;
    private String app_description;
    private String app_name;
    private String app_os;

    public YouAppiResponseAppDetails() {
    }

    public YouAppiResponseAppDetails(String app_id, String app_icon, String app_description, String app_name, String app_os) {
        this.app_id = app_id;
        this.app_icon = app_icon;
        this.app_description = app_description;
        this.app_name = app_name;
        this.app_os = app_os;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(String app_icon) {
        this.app_icon = app_icon;
    }

    public String getApp_description() {
        return app_description;
    }

    public void setApp_description(String app_description) {
        this.app_description = app_description;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_os() {
        return app_os;
    }

    public void setApp_os(String app_os) {
        this.app_os = app_os;
    }
}
