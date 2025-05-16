package com.taskify.user_management.exception;

public class ResourceNotFoundException extends  RuntimeException{

        private String resourceName;
        private String fieldName;
        private long fieldValue;
        public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
            super(String.format("%s not found with %s: %d",resourceName,fieldName,fieldValue));

        }
}
