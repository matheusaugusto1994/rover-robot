package com.nasa.roverrobot.exception;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;

import lombok.Getter;

@Getter
public class InvalidCommandException extends RuntimeException {

  private final String message = INVALID_COMMAND_MSG_EXCEPTION;
  private final String details;

  public InvalidCommandException(String details) {
    this.details = details;
  }
}
