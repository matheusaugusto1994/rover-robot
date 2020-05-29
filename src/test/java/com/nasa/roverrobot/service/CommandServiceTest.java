package com.nasa.roverrobot.service;

import static com.nasa.roverrobot.utils.Constants.INVALID_COMMAND_MSG_EXCEPTION;
import static com.nasa.roverrobot.utils.Constants.INVALID_POSITION_MSG_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.exception.InvalidCommandException;
import com.nasa.roverrobot.exception.InvalidPositionException;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class CommandServiceTest extends AbstractUnitTests {

  @InjectMocks private CommandService commandService;

  @Test
  void shouldMove() {
    var input = "M";

    RoverCommandResult result = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(1).y(0).direction("N").build();
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldTurnLeft() {
    var input = "L";

    RoverCommandResult result = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(0).y(0).direction("W").build();
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldTurnRight() {
    var input = "R";

    RoverCommandResult result = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(0).y(0).direction("E").build();
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldMoveAndTurnLeft() {
    var input = "MML";

    RoverCommandResult result = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(2).y(0).direction("W").build();
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldMoveAndTurnRight() {
    var input = "MMR";

    RoverCommandResult result = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(2).y(0).direction("E").build();
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldExecuteAnComplexCommands() {
    var input = "MMRMMRMM";

    RoverCommandResult roverCommandResult = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(0).y(2).direction("S").build();
    assertThat(roverCommandResult).isEqualTo(expected);
  }

  @Test
  void shouldExecuteAnComplexCommandsAndReturnToInitialPosition() {
    var input = "MMMMRMRMMLMMMRMMRMMMMR";

    RoverCommandResult roverCommandResult = commandService.executeCommand(input);

    RoverCommandResult expected = RoverCommandResult.builder().x(0).y(0).direction("N").build();
    assertThat(roverCommandResult).isEqualTo(expected);
  }

  @Test
  void shouldThrowInvalidCommandException() {
    var input = "MAT";

    assertThrows(
        InvalidCommandException.class,
        () -> commandService.executeCommand(input),
        INVALID_COMMAND_MSG_EXCEPTION);
  }

  @Test
  void shouldThrowInvalidPositionException() {
    var input = "MMMMMMMMMMM";

    assertThrows(
        InvalidPositionException.class,
        () -> commandService.executeCommand(input),
        INVALID_POSITION_MSG_EXCEPTION);
  }
}
