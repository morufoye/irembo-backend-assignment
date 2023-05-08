package com.assignment.backend.enums;

public enum MaritalStatusEnum {

    SINGLE("SINGLE"),
    MARRIED("MARRIED"),
    DIVORCED("DIVORCED"),
    WIDOWED("WIDOWED");

    private final String value;
    private MaritalStatusEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
