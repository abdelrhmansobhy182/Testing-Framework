package models.requests;

import enums.RequestStatus;
import models.User;

public class CustomerRequest extends Request{

    private User customer;
    private String giftId;

    public CustomerRequest() {
    }

    public CustomerRequest(String id, Float amount, String addressId, String giftId, String collectionDate) {
        this.id = id;
        this.amount = amount;
        this.addressId = addressId;
        this.collectionDate = collectionDate;
        this.giftId = giftId;
        this.status = RequestStatus.DISPATCHED;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public User getCustomer() {
        return customer;
    }

    public String getGiftId() {
        return giftId;
    }
}
