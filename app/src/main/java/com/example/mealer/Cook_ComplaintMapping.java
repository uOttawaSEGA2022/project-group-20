package com.example.mealer;

public class Cook_ComplaintMapping {

    String cook_username;
    String complain;

    public Cook_ComplaintMapping() {
    }

    public Cook_ComplaintMapping(String cook_username, String complain) {
        this.cook_username = cook_username;
        this.complain = complain;
    }

    public String getCook_username() {
        return cook_username;
    }

    public void setCook_username(String cook_username) {
        this.cook_username = cook_username;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

}
