package com.nasa.roverrobot.command;

import com.nasa.roverrobot.vo.RoverCommandResult;

public interface Command {

  boolean canExecute(String command);

  void execute(RoverCommandResult roverCommandResult);
}
