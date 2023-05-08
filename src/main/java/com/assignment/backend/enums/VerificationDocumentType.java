package com.assignment.backend.enums;

public enum VerificationDocumentType {

    NATIONAL_IDENTITY_CARD("NATIONAL IDENTITY CARD"),
    INTERNATIONAL_PASSPORT("INTERNATIONAL PASSPORT");

    private final String value;
    private VerificationDocumentType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
