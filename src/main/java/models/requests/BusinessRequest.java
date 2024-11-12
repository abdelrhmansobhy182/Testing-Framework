package models.requests;

import models.Container;

import java.util.List;

public class BusinessRequest extends Request{
    private String dayConst;
    private String containerId;
    private int containerQuantity;
    private String time;
    private String date;

    public BusinessRequest() {
    }

    public BusinessRequest(String day, String addressId, Float amount, String containerId,int containerQuantity, String time, String date) {
        this.dayConst = day;
        this.addressId = addressId;
        this.amount = amount;
        this.containerId = containerId;
        this.containerQuantity = containerQuantity;
        this.date = date;
        this.time = time;
    }

    public void setDayConst(String dayConst) {
        this.dayConst = dayConst;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public void setContainerQuantity(int containerQuantity) {
        this.containerQuantity = containerQuantity;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayConst() {
        return dayConst;
    }

    public String getContainerId() {
        return containerId;
    }

    public int getContainerQuantity() {
        return containerQuantity;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
