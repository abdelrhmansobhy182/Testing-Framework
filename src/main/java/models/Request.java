package models;

import enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private String id;
    private RequestStatus requestStatus;
    private User customer;
    private Float amount;
    private String giftId;
    private String addressId;
    private String collectionDate;

    public Request() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getId() {
        return id;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public User getCustomer() {
        return customer;
    }

    public Float getAmount() {
        return amount;
    }

    public String getGiftId() {
        return giftId;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getCollectionDate() {
        return collectionDate;
    }
}


