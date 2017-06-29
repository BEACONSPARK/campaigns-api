package com.engageya.models.YouAppi;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by LIOR on 25/06/2017.
 */
@Component
public class YouAppiTask {
    private static final Logger logger = LoggerFactory.getLogger(YouAppiTask.class);

    @Autowired
    RestTemplate restTemplate;

    private String url = "https://service.youappi.com/cmp/campaigninfo?accesstoken=06523211-33a3-4bf9-b2f2-9aee8c696b63";

    @Scheduled(fixedDelay = 1000 * 60 * 15) //15 minutes since the end of the task
    private void updateOfflineCampaigns(){
        String jsonResponse = restTemplate.getForObject(url, String.class);

        YouAppiResponse youAppiResponse = buildResponseObjects(jsonResponse);

        handleResponse(youAppiResponse);

    }

    private void handleResponse(YouAppiResponse youAppiResponse) {
        List<YouAppiResponseCampaign> campaigns = youAppiResponse.getData().getYouAppiResponseCampaigns();
        for (YouAppiResponseCampaign campaign: campaigns){
            if(checkIfNewCampaign(campaign)){
                createNewCampaign(campaign);
            }
        }
        stopInactiveCampaigns();
        
    }

    private boolean checkIfNewCampaign(YouAppiResponseCampaign campaign) {
        return false;
    }

    private YouAppiResponse buildResponseObjects(String jsonResponse) {
        YouAppiResponse youAppiResponse = new YouAppiResponse();
        Gson gson = new Gson();
        try {
            JSONObject responseObject = new JSONObject(jsonResponse);

            youAppiResponse.setStatus(responseObject.getInt("status"));
            youAppiResponse.setStatusMessage(responseObject.getString("statusMessage"));
            youAppiResponse.setTotalNumberOfEntries(responseObject.getInt("totalNumberOfEntries"));

            JSONObject dataObject = responseObject.getJSONObject("data");
            YouAppiResponseData youAppiResponseData = new YouAppiResponseData();
            java.util.Iterator<String> campaignsIterator = dataObject.keys();
            while (campaignsIterator.hasNext()){
                JSONObject campaign = dataObject.getJSONObject(campaignsIterator.next());
                YouAppiResponseCampaign youAppiResponseCampaign = gson.fromJson(campaign.toString(),YouAppiResponseCampaign.class);
                youAppiResponseData.getYouAppiResponseCampaigns().add(youAppiResponseCampaign);
            }

            youAppiResponse.setData(youAppiResponseData);

        } catch (JSONException e) {
            logger.error("Failedc to parse response", e);
        }
        return youAppiResponse;
    }
}
