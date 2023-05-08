package com.assignment.backend.enums;

public enum GenderEnum {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String value;
    private GenderEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
