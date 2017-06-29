package com.engageya.models.YouAppi;

/**
 * Created by LIOR on 25/06/2017.
 */
public class YouAppiResponse {
    private int status;
    private String statusMessage;
    private YouAppiResponseData data;
    private int totalNumberOfEntries;

    public YouAppiResponse() {
    }

    public YouAppiResponse(int status, String statusMessage, YouAppiResponseData data, int totalNumberOfEntries) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.data = data;
        this.totalNumberOfEntries = totalNumberOfEntries;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public YouAppiResponseData getData() {
        return data;
    }

    public void setData(YouAppiResponseData data) {
        this.data = data;
    }

    public int getTotalNumberOfEntries() {
        return totalNumberOfEntries;
    }

    public void setTotalNumberOfEntries(int totalNumberOfEntries) {
        this.totalNumberOfEntries = totalNumberOfEntries;
    }
}
