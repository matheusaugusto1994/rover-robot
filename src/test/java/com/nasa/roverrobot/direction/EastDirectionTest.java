package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.NORTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.SOUTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;

class EastDirectionTest extends AbstractUnitTests {

  private final EastDirection eastDirection = new EastDirection();

  @Test
  void isSameDirectionShouldReturnTrue() {
    assertTrue(eastDirection.isSameDirection(EAST_DIRECTION));
  }

  @Test
  void isSameDirectionShouldReturnFalse() {
    assertFalse(eastDirection.isSameDirection(WEST_DIRECTION));
  }

  @Test
  void shouldMoveShouldReturnTrue() {
    var roverCommandResult = RoverCommandResult.builder().build();

    assertTrue(eastDirection.shouldMove(roverCommandResult));
  }

  @Test
  void shouldMoveShouldReturnFalse() {
    var roverCommandResult = RoverCommandResult.builder().y(4).build();

    assertFalse(eastDirection.shouldMove(roverCommandResult));
  }

  @Test
  void leftShouldReturnNorthDirection() {
    assertThat(eastDirection.left()).isEqualTo(NORTH_DIRECTION);
  }

  @Test
  void rightShouldReturnSouthDirection() {
    assertThat(eastDirection.right()).isEqualTo(SOUTH_DIRECTION);
  }

  @Test
  void moveShouldIncrementPosition() {
    var roverCommandResult = RoverCommandResult.builder().build();

    eastDirection.move(roverCommandResult);

    assertThat(roverCommandResult).isEqualTo(RoverCommandResult.builder().y(1).build());
  }
}
