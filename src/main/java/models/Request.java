package models;

import enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private String id;
    private RequestStatus status;
    private User customer;
    private Float amount;
    private String giftId;
    private String addressId;
    private String collectionDate;

    public Request() {
    }

    public Request(String id, Float amount, String addressId, String giftId, String collectionDate) {
        this.id = id;
        this.amount = amount;
        this.addressId = addressId;
        this.giftId = giftId;
        this.collectionDate = collectionDate;
        this.status = RequestStatus.DISPATCHED;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(RequestStatus requestStatus) {
        this.status = requestStatus;
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

    public RequestStatus getStatus() {
        return status;
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


