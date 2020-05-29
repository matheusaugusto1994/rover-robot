package com.nasa.roverrobot.command;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.LEFT_COMMAND;
import static com.nasa.roverrobot.utils.Constants.MOVE_COMMAND;
import static com.nasa.roverrobot.utils.Constants.RIGHT_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.exception.InvalidCommandException;
import org.junit.jupiter.api.Test;

class CommandFilterTest extends AbstractUnitTests {

  private final CommandFilter commandFilter = new CommandFilter();

  @Test
  void shouldFilterMoveCommand() {
    Command command = commandFilter.filter(MOVE_COMMAND);

    assertThat(command).isInstanceOf(MoveCommand.class);
  }

  @Test
  void shouldFilterLeftCommand() {
    Command command = commandFilter.filter(LEFT_COMMAND);

    assertThat(command).isInstanceOf(LeftCommand.class);
  }

  @Test
  void shouldFilterRightCommand() {
    Command command = commandFilter.filter(RIGHT_COMMAND);

    assertThat(command).isInstanceOf(RightCommand.class);
  }

  @Test
  void shouldThrowInvalidCommandException() {
    assertThrows(
        InvalidCommandException.class,
        () -> commandFilter.filter("A"),
        INVALID_COMMAND_MSG_EXCEPTION);
  }
}
