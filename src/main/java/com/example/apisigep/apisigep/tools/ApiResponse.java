package com.example.apisigep.apisigep.tools;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ApiResponse implements Serializable {

    private boolean status;
    private String message;
    private Object data;

    public ApiResponse(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseEntity<ApiResponse> success(Object data) {
        ApiResponse response = new ApiResponse(true, "Datos cargados", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse> success(Object data, String message) {
        ApiResponse response = new ApiResponse(true, message, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse> success(Object data, String message, HttpStatus code) {
        ApiResponse response = new ApiResponse(true, message, data);
        return new ResponseEntity<>(response, code);
    }

    public static ResponseEntity<ApiResponse> error() {
        ApiResponse response = new ApiResponse(false, "Error al realizar está operación", null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    public static ResponseEntity<ApiResponse> error(String message) {
        ApiResponse response = new ApiResponse(false, message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ApiResponse> error(String message, HttpStatus code) {
        ApiResponse response = new ApiResponse(false, message, null);
        return new ResponseEntity<>(response, code);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
