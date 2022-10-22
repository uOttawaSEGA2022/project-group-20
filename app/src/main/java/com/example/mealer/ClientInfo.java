package com.example.mealer;

public class ClientInfo {

    /*
    private String firstNameField;
    private String lastNameField;
    private String emailAddressField;
    private String passwordField;
    private String postalAddressField;
    private long cardNumber2;
    private String HolderName2;
    private String expiryDate2;
    private int cvv2;
    private String descriptionField;
    */

    private String firstnameField, emailAddressField, passwordField;

    //Constructors

    public ClientInfo(String firstnameField, String emailAddressField, String passwordField) {
        this.firstnameField = firstnameField;
        this.emailAddressField = emailAddressField;
        this.passwordField = passwordField;
    }

    public ClientInfo() {
    }

    //Getters & Setters

    public String getFirstnameField() {
        return firstnameField;
    }

    public void setFirstnameField(String firstnameField) {
        this.firstnameField = firstnameField;
    }

    public String getEmailAddressField() {
        return emailAddressField;
    }

    public void setEmailAddressField(String emailAddressField) {
        this.emailAddressField = emailAddressField;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    // To string methods


    @Override
    public String toString() {
        return "ClientInfo{" +
                "firstnameField='" + firstnameField + '\'' +
                ", emailAddressField='" + emailAddressField + '\'' +
                ", passwordField='" + passwordField + '\'' +
                '}';
    }
}
