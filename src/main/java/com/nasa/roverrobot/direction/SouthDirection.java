package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.MIN_VERTICAL_POSITION;
import static com.nasa.roverrobot.utils.Constants.SOUTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;

import com.nasa.roverrobot.vo.RoverCommandResult;

public class SouthDirection implements Direction {

  @Override
  public boolean isSameDirection(String direction) {
    return SOUTH_DIRECTION.equals(direction);
  }

  @Override
  public boolean shouldMove(RoverCommandResult roverCommandResult) {
    return MIN_VERTICAL_POSITION < roverCommandResult.getX();
  }

  @Override
  public String left() {
    return EAST_DIRECTION;
  }

  @Override
  public String right() {
    return WEST_DIRECTION;
  }

  @Override
  public void move(RoverCommandResult roverCommandResult) {
    roverCommandResult.setX(roverCommandResult.getX() - 1);
  }
}
