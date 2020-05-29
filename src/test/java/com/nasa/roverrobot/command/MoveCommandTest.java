package com.nasa.roverrobot.command;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.INVALID_POSITION_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.MOVE_COMMAND;
import static com.nasa.roverrobot.utils.Constants.RIGHT_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.exception.InvalidCommandException;
import com.nasa.roverrobot.exception.InvalidPositionException;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;

class MoveCommandTest extends AbstractUnitTests {

  private final MoveCommand moveCommand = new MoveCommand();

  @Test
  void canExecuteShouldReturnTrue() {
    var canExecute = moveCommand.canExecute(MOVE_COMMAND);

    assertTrue(canExecute);
  }

  @Test
  void canExecuteShouldReturnFalse() {
    var canExecute = moveCommand.canExecute(RIGHT_COMMAND);

    assertFalse(canExecute);
  }

  @Test
  void shouldExecuteMoveCommand() {
    var roverCommandResult = RoverCommandResult.builder().build();

    moveCommand.execute(roverCommandResult);

    assertThat(roverCommandResult).isEqualTo(RoverCommandResult.builder().x(1).build());
  }

  @Test
  void shouldThrowInvalidCommandException() {
    var roverCommandResult = RoverCommandResult.builder().direction("A").build();

    assertThrows(
        InvalidCommandException.class,
        () -> moveCommand.execute(roverCommandResult),
        INVALID_COMMAND_MSG_EXCEPTION);
  }

  @Test
  void shouldThrowInvalidPositionException() {
    var roverCommandResult = RoverCommandResult.builder().x(4).build();

    assertThrows(
        InvalidPositionException.class,
        () -> moveCommand.execute(roverCommandResult),
        INVALID_POSITION_MSG_EXCEPTION);
  }
}
