package com.engageya.models.YouAppi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LIOR on 26/06/2017.
 */
public class YouAppiResponseCampaign {
    private int offer_id;
    private long campaign_id;
    private String platform;
    private String cpi;
    private String app_url;
    private String redirect_url;
    private ArrayList<String> countries;
    private ArrayList<String> cities;
    private int max_daily;
    private int max_total;
    private String capping_type;
    private YouAppiResponseAppDetails app_details;
    private Map<String, String> creatives;
    private ArrayList<String> blacklist_publisherTokens;
    private boolean adid_required;
    private boolean idfa_required;
    private String minOS;
    private String deviceType;

    public YouAppiResponseCampaign() {
        creatives = new HashMap<>();
    }

    public YouAppiResponseCampaign(int offer_id, long campaign_id, String platform, String cpi, String app_url, String redirect_url, ArrayList<String> countries, ArrayList<String> cities, int max_daily, int max_total, String capping_type, YouAppiResponseAppDetails app_details, Map<String, String> creatives, ArrayList<String> blacklist_publisherTokens, boolean adid_required, boolean idfa_required, String minOS, String deviceType) {
        this.offer_id = offer_id;
        this.campaign_id = campaign_id;
        this.platform = platform;
        this.cpi = cpi;
        this.app_url = app_url;
        this.redirect_url = redirect_url;
        this.countries = countries;
        this.cities = cities;
        this.max_daily = max_daily;
        this.max_total = max_total;
        this.capping_type = capping_type;
        this.app_details = app_details;
        this.creatives = creatives;
        this.blacklist_publisherTokens = blacklist_publisherTokens;
        this.adid_required = adid_required;
        this.idfa_required = idfa_required;
        this.minOS = minOS;
        this.deviceType = deviceType;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public long getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(long campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCpi() {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public int getMax_daily() {
        return max_daily;
    }

    public void setMax_daily(int max_daily) {
        this.max_daily = max_daily;
    }

    public int getMax_total() {
        return max_total;
    }

    public void setMax_total(int max_total) {
        this.max_total = max_total;
    }

    public String getCapping_type() {
        return capping_type;
    }

    public void setCapping_type(String capping_type) {
        this.capping_type = capping_type;
    }

    public YouAppiResponseAppDetails getApp_details() {
        return app_details;
    }

    public void setApp_details(YouAppiResponseAppDetails app_details) {
        this.app_details = app_details;
    }

    public Map<String, String> getCreatives() {
        return creatives;
    }

    public void setCreatives(Map<String, String> creatives) {
        this.creatives = creatives;
    }

    public ArrayList<String> getBlacklist_publisherTokens() {
        return blacklist_publisherTokens;
    }

    public void setBlacklist_publisherTokens(ArrayList<String> blacklist_publisherTokens) {
        this.blacklist_publisherTokens = blacklist_publisherTokens;
    }

    public boolean isAdid_required() {
        return adid_required;
    }

    public void setAdid_required(boolean adid_required) {
        this.adid_required = adid_required;
    }

    public boolean isIdfa_required() {
        return idfa_required;
    }

    public void setIdfa_required(boolean idfa_required) {
        this.idfa_required = idfa_required;
    }

    public String getMinOS() {
        return minOS;
    }

    public void setMinOS(String minOS) {
        this.minOS = minOS;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
