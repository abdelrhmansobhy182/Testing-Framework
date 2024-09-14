package backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String type;
    private String role;
    private String phone;
    private String password;
    private String id;
    private String[] interfaces;
    private String jwtToken;

    public User() {
    }

    public User(String type, String role, String phone, String password) {
        this.type = type;
        this.role = role;
        this.phone = phone;
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setRole(String role) {
        this.role = role;
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

    public void setInterfaces(String[] interfaces) {
        this.interfaces = interfaces;
    }

    public String getType() {
        return type;
    }

    public String getRole() {
        return role;
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

    public String[] getInterfaces() {
        return interfaces;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}


