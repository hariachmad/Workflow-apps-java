package com.example.demo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "fullname is required")
    private String fullname;

    @NotEmpty(message = "username is required")
    private String username;

    private String hashPassword;

    @NotEmpty(message = "phoneNumber is required")
    private String phoneNumber;

    @NotEmpty(message = "address is required")
    private String address;

    private String urlImgProfile;

    private Integer userRating=0;

    public User(){};

    public User(@NotEmpty(message = "fullname is required") String fullname,
            @NotEmpty(message = "username is required") String username, String hashPassword,
            @NotEmpty(message = "phoneNumber is required") String phoneNumber,
            @NotEmpty(message = "address is required") String address, String urlImgProfile) {
        this.fullname = fullname;
        this.username = username;
        this.hashPassword = hashPassword;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.urlImgProfile = urlImgProfile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlImgProfile() {
        return urlImgProfile;
    }

    public void setUrlImgProfile(String urlImgProfile) {
        this.urlImgProfile = urlImgProfile;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }    
}
