package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.AuthTypes;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private AuthTypes type;
    private String phone;
    private String password;
    private String id;
    private List<Role> roles;
    private String jwtToken;

    public User() {
    }

    public User(AuthTypes type, String phone, String password) {
        this.phone = phone;
        this.type = type;
        this.password = password;
    }

    public AuthTypes getType() {
        return type;
    }

    public void setType(AuthTypes type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
