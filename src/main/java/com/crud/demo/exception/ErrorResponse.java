package com.crud.demo.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @Autowired
    private String errorCode;

    @Autowired
    private String message;

}
