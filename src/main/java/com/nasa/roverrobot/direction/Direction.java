package com.nasa.roverrobot.direction;

import com.nasa.roverrobot.vo.RoverCommandResult;

public interface Direction {

  boolean isSameDirection(String direction);

  boolean shouldMove(RoverCommandResult roverCommandResult);

  String left();

  String right();

  void move(RoverCommandResult roverCommandResult);
}
