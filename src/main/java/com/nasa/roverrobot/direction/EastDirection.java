package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.MAX_HORIZONTAL_POSITION;
import static com.nasa.roverrobot.utils.Constants.NORTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.SOUTH_DIRECTION;

import com.nasa.roverrobot.vo.RoverCommandResult;

public class EastDirection implements Direction {

  @Override
  public boolean isSameDirection(String direction) {
    return EAST_DIRECTION.equals(direction);
  }

  @Override
  public boolean shouldMove(RoverCommandResult roverCommandResult) {
    return MAX_HORIZONTAL_POSITION > roverCommandResult.getY();
  }

  @Override
  public String left() {
    return NORTH_DIRECTION;
  }

  @Override
  public String right() {
    return SOUTH_DIRECTION;
  }

  @Override
  public void move(RoverCommandResult roverCommandResult) {
    roverCommandResult.setY(roverCommandResult.getY() + 1);
  }
}
