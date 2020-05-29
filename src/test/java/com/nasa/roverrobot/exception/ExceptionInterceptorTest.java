package com.nasa.roverrobot.exception;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.INVALID_POSITION_MSG_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

import com.nasa.roverrobot.AbstractSpringContextTests;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ExceptionInterceptorTest extends AbstractSpringContextTests {

  @Spy @InjectMocks
  private ExceptionInterceptor exceptionInterceptorSpy;

  @Test
  void shouldInterceptInvalidCommandException() {
    var invalidCommandException = new InvalidCommandException("Some details");
    var response = exceptionInterceptorSpy.handleAllExceptions(invalidCommandException);
    var exceptionResponse = new CustomDetailsException(INVALID_COMMAND_MSG_EXCEPTION, "Some details");
    var expected = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    assertThat(response.getBody()).isEqualTo(expected.getBody());
  }

  @Test
  void shouldInterceptInvalidPositionException() {
    var invalidPositionException = new InvalidPositionException("Some details");
    var response = exceptionInterceptorSpy.handleAllExceptions(invalidPositionException);
    var exceptionResponse = new CustomDetailsException(INVALID_POSITION_MSG_EXCEPTION, "Some details");
    var expected = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    assertThat(response.getBody()).isEqualTo(expected.getBody());
  }
}
