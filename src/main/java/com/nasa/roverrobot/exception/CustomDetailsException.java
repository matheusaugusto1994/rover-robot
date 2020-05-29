package com.nasa.roverrobot.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomDetailsException {
    private String message;
    private String details;
}
