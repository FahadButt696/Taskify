package com.taskify.project_management.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status,
            WebRequest request) {
        Map<String,String> errors=new HashMap<>();
        List<ObjectError> errorsList= ex.getBindingResult().getAllErrors();
        errorsList.forEach(
                (error)->{
                    String Field=((FieldError)error).getField();
                    String message=error.getDefaultMessage();
                    errors.put(Field,message);
                }
        );

        return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ProjectNotFoundException exception, WebRequest webRequest
    ){
        ErrorDetails errorDetails= new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(ticketAlreadyExistException.class)
//    public ResponseEntity<errorDetails> handleTickerAlreadyExistException(
//            ticketAlreadyExistException exception, WebRequest webRequest
//    ){
//        errorDetails errorDetails= new errorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "TICKET_ALREADY_EXISTS"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(categoryAlreadyExistException.class)
//    public ResponseEntity<errorDetails> handlecategoryAlreadyExistException(
//            categoryAlreadyExistException exception, WebRequest webRequest
//    ){
//        errorDetails errorDetails= new errorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "CATEGORY_ALREADY_EXISTS"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleAllException(
//            Exception exception, WebRequest webRequest
//    ){
//        ErrorDetails errorDetails= new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "INTERNAL_SERVER_ERROR"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
