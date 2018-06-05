package com.opendatadelaware.paratransitapp.model;

import java.io.Serializable;

public class User implements Serializable{

    String applicantName;
    String applicantEmail;
    String applicantPassword;
    ApplicantAddress applicantAddress;
    String phoneNumber;
    String lastFour;
    Gender gender;
    String addressAsString;
    String genderAsString;
    String birthday;

    public User() {}

    public User(String applicantName, String applicantEmail, String applicantPassword, Gender gender) {
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.applicantPassword = applicantPassword;
        this.gender = gender;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantPassword() {
        return applicantPassword;
    }

    public void setApplicantPassword(String applicantPassword) {
        this.applicantPassword = applicantPassword;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public ApplicantAddress getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(ApplicantAddress applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }
}
