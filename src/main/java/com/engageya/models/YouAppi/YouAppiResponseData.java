package com.engageya.models.YouAppi;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LIOR on 25/06/2017.
 */
public class YouAppiResponseData {
    List<YouAppiResponseCampaign> youAppiResponseCampaigns;

    public YouAppiResponseData() {
        youAppiResponseCampaigns = new LinkedList<>();
    }

    public YouAppiResponseData(List<YouAppiResponseCampaign> youAppiResponseCampaigns) {
        this.youAppiResponseCampaigns = youAppiResponseCampaigns;
    }

    public List<YouAppiResponseCampaign> getYouAppiResponseCampaigns() {
        return youAppiResponseCampaigns;
    }

    public void setYouAppiResponseCampaigns(List<YouAppiResponseCampaign> youAppiResponseCampaigns) {
        this.youAppiResponseCampaigns = youAppiResponseCampaigns;
    }
}
