package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.MIN_HORIZONTAL_POSITION;
import static com.nasa.roverrobot.utils.Constants.NORTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.SOUTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;

import com.nasa.roverrobot.vo.RoverCommandResult;

public class WestDirection implements Direction {

  @Override
  public boolean isSameDirection(String direction) {
    return WEST_DIRECTION.equals(direction);
  }

  @Override
  public boolean shouldMove(RoverCommandResult roverCommandResult) {
    return MIN_HORIZONTAL_POSITION < roverCommandResult.getY();
  }

  @Override
  public String left() {
    return SOUTH_DIRECTION;
  }

  @Override
  public String right() {
    return NORTH_DIRECTION;
  }

  @Override
  public void move(RoverCommandResult roverCommandResult) {
    roverCommandResult.setY(roverCommandResult.getY() - 1);
  }
}
