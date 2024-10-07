package com.example.finalSpringProject.finalSpringProject.exceptions;

public class CustomException extends RuntimeException{

    private String massage;

    public CustomException(String massage) {
        super(massage);
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
