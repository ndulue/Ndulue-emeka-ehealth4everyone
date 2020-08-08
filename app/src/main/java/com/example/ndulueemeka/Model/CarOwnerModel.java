package com.example.ndulueemeka.Model;

import com.google.gson.annotations.SerializedName;

public class CarOwnerModel {

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("email")
    private String email;

    @SerializedName("country")
    private String country;

    @SerializedName("car_model")
    private String car_model;

    @SerializedName("car_model_year")
    private int car_model_year;

    @SerializedName("car_color")
    private String car_color;

    @SerializedName("gender")
    private String gender;

    @SerializedName("job_title")
    private String job_title;

    @SerializedName("bio")
    private String bio;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getCar_model_year() {
        return car_model_year;
    }

    public void setCar_model_year(int car_model_year) {
        this.car_model_year = car_model_year;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
