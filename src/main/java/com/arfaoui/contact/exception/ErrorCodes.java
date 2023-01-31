package com.arfaoui.contact.exception;


public enum ErrorCodes {
    USER_NOT_FOUND(1000),
    USER_NOT_VALID(2000),
    CONTACT_IS_NOT_VALID(2001),
    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}