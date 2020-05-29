package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.MAX_VERTICAL_POSITION;
import static com.nasa.roverrobot.utils.Constants.NORTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;

import com.nasa.roverrobot.vo.RoverCommandResult;

public class NorthDirection implements Direction {

  @Override
  public boolean isSameDirection(String direction) {
    return NORTH_DIRECTION.equals(direction);
  }

  @Override
  public boolean shouldMove(RoverCommandResult roverCommandResult) {
    return MAX_VERTICAL_POSITION > roverCommandResult.getX();
  }

  @Override
  public String left() {
    return WEST_DIRECTION;
  }

  @Override
  public String right() {
    return EAST_DIRECTION;
  }

  @Override
  public void move(RoverCommandResult roverCommandResult) {
    roverCommandResult.setX(roverCommandResult.getX() + 1);
  }
}
