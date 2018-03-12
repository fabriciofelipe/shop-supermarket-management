package com.shop.supermarket.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

    private final String error;
    private final HttpStatus httpStatus;

    @JsonCreator
    public ErrorResponse(@JsonProperty("error") final String error, @JsonProperty("http status") final HttpStatus status) {
        this.error = error;
        this.httpStatus = status;
    }

}