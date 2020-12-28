package com.example.phonebook.be.Enums;

public enum Param {
    Email,
    Phone,
    Address,
    Skype;

    public Param setParam(String param){
        switch(param){
            case "Email":
                return Param.Email;
            case "Phone":
                return Param.Phone;
            case "Address":
                return Param.Address;
            case "Skype":
                return Param.Skype;
            default:
                return null;
        }
    }
}
