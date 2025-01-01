package com.ltp.contacts.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private LocalDateTime timestap;

    public ErrorResponse(String message) {
        this.message = message;
        this.timestap = LocalDateTime.now();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestap() {
        return this.timestap;
    }

    public void setTimestap(LocalDateTime timestap) {
        this.timestap = timestap;
    }

}
