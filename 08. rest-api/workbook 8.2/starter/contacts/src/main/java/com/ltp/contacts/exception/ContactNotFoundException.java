package com.ltp.contacts.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String id) {
        super("The id \"" + id + "\" doesn't exist in our records");
    }
}
