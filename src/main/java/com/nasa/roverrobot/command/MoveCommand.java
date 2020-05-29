package com.nasa.roverrobot.command;

import static com.nasa.roverrobot.utils.Constants.MOVE_COMMAND;

import com.nasa.roverrobot.direction.DirectionFilter;
import com.nasa.roverrobot.exception.InvalidCommandException;
import com.nasa.roverrobot.exception.InvalidPositionException;
import com.nasa.roverrobot.vo.RoverCommandResult;
import java.util.Optional;

public class MoveCommand implements Command {

  @Override
  public boolean canExecute(String command) {
    return MOVE_COMMAND.equals(command);
  }

  @Override
  public void execute(RoverCommandResult roverCommandResult) {
    var direction =
        new DirectionFilter()
            .filter(roverCommandResult.getDirection())
            .orElseThrow(() -> new InvalidCommandException(
                "Invalid direction '" + roverCommandResult.getDirection() + "'"));

    Optional.of(direction)
        .filter(d -> d.shouldMove(roverCommandResult))
        .orElseThrow(() -> new InvalidPositionException(
            "Could not move to '" + roverCommandResult.getDirection() + "'. " +
                "The movements must respect the 5x5 size of the matrix. "))
        .move(roverCommandResult);
  }
}
