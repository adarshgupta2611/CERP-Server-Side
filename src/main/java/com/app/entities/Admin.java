package com.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Admin extends BaseEntity {
    @Column(length = 30, unique = true)
    @NotBlank(message = "Email id is required")
    @Email(message = "Invalid Email address")
    private String email;
    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
    @JsonProperty(access = Access.WRITE_ONLY)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})", message = "Invalid Password!")
    private String password;

    public Admin() {
        super();
    }

    public Admin(@NotBlank(message = "Email id is required") @Email(message = "Invalid Email address") String email, @NotBlank(message = "Password is required") @Size(min = 6, message = "Password should have at least 6 characters") @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})", message = "Invalid Password!") String password) {
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
        return "Admin [email=" + email + "]";
    }


}