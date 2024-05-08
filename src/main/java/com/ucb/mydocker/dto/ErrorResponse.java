package com.ucb.mydocker.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    
    @NotNull(message = "Error message must not be null")
    private String message;
    
    public ErrorResponse(String message) {
        this.message = message;
    }
}
