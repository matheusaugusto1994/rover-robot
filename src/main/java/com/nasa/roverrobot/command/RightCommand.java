package com.nasa.roverrobot.command;

import static com.nasa.roverrobot.utils.Constants.RIGHT_COMMAND;

import com.nasa.roverrobot.direction.DirectionFilter;
import com.nasa.roverrobot.exception.InvalidCommandException;
import com.nasa.roverrobot.vo.RoverCommandResult;

public class RightCommand implements Command {

  @Override
  public boolean canExecute(String command) {
    return RIGHT_COMMAND.equals(command);
  }

  @Override
  public void execute(RoverCommandResult roverCommandResult) {
    var direction =
        new DirectionFilter()
            .filter(roverCommandResult.getDirection())
            .orElseThrow(() -> new InvalidCommandException(
                "Invalid direction '" + roverCommandResult.getDirection() + "'"));

    roverCommandResult.setDirection(direction.right());
  }
}
