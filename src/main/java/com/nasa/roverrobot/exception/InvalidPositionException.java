package com.nasa.roverrobot.exception;

import static com.nasa.roverrobot.utils.Constants.INVALID_POSITION_MSG_EXCEPTION;

import lombok.Getter;

@Getter
public class InvalidPositionException extends RuntimeException {

  private final String message = INVALID_POSITION_MSG_EXCEPTION;
  private final String details;

  public InvalidPositionException(String details) {
    this.details = details;
  }
}
