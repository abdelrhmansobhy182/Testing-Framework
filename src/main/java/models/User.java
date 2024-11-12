package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import enums.AuthTypes;
import models.requests.Request;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private AuthTypes type;
    private String phone;
    private String password;
    private String id;
    private List<Role> roles;
    private String jwtToken;
    private List<Request> requests;

    public User() {
    }

    public User(AuthTypes type, String phone, String password) {
        this.phone = phone;
        this.type = type;
        this.password = password;
    }

    public void setType(AuthTypes type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public AuthTypes getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public List<Request> getRequests() {
        return requests;
    }
}
