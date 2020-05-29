package com.nasa.roverrobot.service;

import com.nasa.roverrobot.command.CommandFilter;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

  private final CommandFilter commandFilter = new CommandFilter();

  public RoverCommandResult executeCommand(String input) {
    var roverCommandResult = RoverCommandResult.builder().build();
    var commands = input.split("");

    for (String inputCommand : commands) {
      commandFilter.filter(inputCommand.toUpperCase())
          .execute(roverCommandResult);
    }

    return roverCommandResult;
  }
}
