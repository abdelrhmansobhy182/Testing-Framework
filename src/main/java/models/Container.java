package models;

public class Container {

    private String containerId;
    private String quantity;

    public Container(String containerId, String quantity) {
        this.containerId = containerId;
        this.quantity = quantity;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getContainerId() {
        return containerId;
    }

    public String getQuantity() {
        return quantity;
    }
}
