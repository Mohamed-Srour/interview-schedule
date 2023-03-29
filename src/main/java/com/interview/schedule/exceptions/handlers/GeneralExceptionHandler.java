package com.interview.schedule.exceptions.handlers;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.interview.schedule.business.dtos.ApiError;
import com.interview.schedule.business.dtos.ErrorResponse;
import com.interview.schedule.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(ResourceNotFoundException ex, HttpServletRequest req) {
        String message = String.format("resource with id:%s is not found", ex.getId());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(true);
        errorResponse.setCode(400);
        errorResponse.setHttpstatus(HttpStatus.valueOf(400));

        return new ResponseEntity<>(errorResponse,errorResponse.getHttpstatus());
    }
    @ExceptionHandler({ Exception.class })
public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
    ApiError apiError = new ApiError(
      HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
    return new ResponseEntity<Object>(
      apiError, new HttpHeaders(), apiError.getStatus());
}
}
