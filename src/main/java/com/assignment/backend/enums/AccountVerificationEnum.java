package com.assignment.backend.enums;

public enum AccountVerificationEnum {

    UNVERIFIED("UNVERIFIED"),
    PENDING_VERIFICATION("PENDING VERIFICATION"),
    VERIFIED("VERIFIED");
    private final String value;
    private AccountVerificationEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
