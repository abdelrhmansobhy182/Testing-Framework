package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    protected String id;
    protected RequestStatus status;
    protected Float amount;
    protected String addressId;
    protected String collectionDate;

    public Request() {
    }

    public Request(String id, Float amount, String addressId, String giftId, String collectionDate) {
        this.id = id;
        this.amount = amount;
        this.addressId = addressId;
        this.collectionDate = collectionDate;
        this.status = RequestStatus.DISPATCHED;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(RequestStatus requestStatus) {
        this.status = requestStatus;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
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

    public Float getAmount() {
        return amount;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getCollectionDate() {
        return collectionDate;
    }
}


