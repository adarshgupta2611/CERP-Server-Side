package com.app.dto;

import java.io.Serializable;

public class AdminDto  implements Serializable{

    private String email;
    private String password;

    public AdminDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDto [email=" + email + "]";
    }


}