package com.taskify.project_management.exception;

public class ProjectNotFoundException extends RuntimeException {

    private String message;


    public ProjectNotFoundException(String message) {
        super();
        this.message =message;
    }
}
