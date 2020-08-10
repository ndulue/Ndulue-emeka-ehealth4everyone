package com.example.ndulueemeka.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
// model class for Filter in HomeActivity
public class FilterModel {

        @SerializedName("id")
        private int id;

        @SerializedName("start_year")
        private int startYear;

        @SerializedName("end_year")
        private int endYear;

        @SerializedName("gender")
        private String gender;

        @SerializedName("countries")
        private List<String> countries = null;

        @SerializedName("colors")
        private List<String> colors = null;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStartYear() {
            return startYear;
        }

        public void setStartYear(int startYear) {
            this.startYear = startYear;
        }

        public int getEndYear() {
            return endYear;
        }

        public void setEndYear(int endYear) {
            this.endYear = endYear;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public List<String> getCountries() {
            return countries;
        }

        public void setCountries(List<String> countries) {
            this.countries = countries;
        }

        public List<String> getColors() {
            return colors;
        }

        public void setColors(List<String> colors) {
            this.colors = colors;
        }

    }


