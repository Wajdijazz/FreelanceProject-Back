package com.freelance.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
    private HttpStatus errCode;
    private String errMsg;
}
