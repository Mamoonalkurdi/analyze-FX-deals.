/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProgresssSoft.Data;

/**
 *
 * @author Mamoun-Alkurdi
 */
public class FXdealsResponse {
    
    private String Status;
    private String ErrorCode;
    private String ErrorMessage;

    @Override
    public String toString() {
        return "FXdealsResponse{" + "Status=" + Status + ", ErrorCode=" + ErrorCode + ", ErrorMessage=" + ErrorMessage + '}';
    }

    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }
    
    
    
}
