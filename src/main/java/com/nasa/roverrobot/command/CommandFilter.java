package com.nasa.roverrobot.command;

import com.google.common.collect.Lists;
import com.nasa.roverrobot.exception.InvalidCommandException;
import java.util.List;

public class CommandFilter {

  private final List<Command> commands =
      Lists.newArrayList(new MoveCommand(), new LeftCommand(), new RightCommand());

  public Command filter(String command) {
    return commands.stream()
        .filter(c -> c.canExecute(command))
        .findFirst()
        .orElseThrow(() -> new InvalidCommandException(
            "Command '"+ command + "' is not valid. Only 'L', 'R' and 'M' commands are valid."));
  }
}
