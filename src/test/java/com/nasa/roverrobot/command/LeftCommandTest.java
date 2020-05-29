package com.nasa.roverrobot.command;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.LEFT_COMMAND;
import static com.nasa.roverrobot.utils.Constants.RIGHT_COMMAND;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.exception.InvalidCommandException;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;

class LeftCommandTest extends AbstractUnitTests {

  private final LeftCommand leftCommand = new LeftCommand();

  @Test
  void canExecuteShouldReturnTrue() {
    var canExecute = leftCommand.canExecute(LEFT_COMMAND);

    assertTrue(canExecute);
  }

  @Test
  void canExecuteShouldReturnFalse() {
    var canExecute = leftCommand.canExecute(RIGHT_COMMAND);

    assertFalse(canExecute);
  }

  @Test
  void shouldExecuteLeftCommand() {
    var roverCommandResult = RoverCommandResult.builder().build();

    leftCommand.execute(roverCommandResult);

    assertThat(roverCommandResult)
        .isEqualTo(RoverCommandResult.builder().y(0).x(0).direction(WEST_DIRECTION).build());
  }

  @Test
  void shouldThrowExceptionInExecute() {
    var roverCommandResult = RoverCommandResult.builder().direction("A").build();

    assertThrows(
        InvalidCommandException.class,
        () -> leftCommand.execute(roverCommandResult),
        INVALID_COMMAND_MSG_EXCEPTION);
  }
}
