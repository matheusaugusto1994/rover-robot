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

class WestDirectionTest extends AbstractUnitTests {

  private final WestDirection westDirection = new WestDirection();

  @Test
  void isSameDirectionShouldReturnTrue() {
    assertTrue(westDirection.isSameDirection(WEST_DIRECTION));
  }

  @Test
  void isSameDirectionShouldReturnFalse() {
    assertFalse(westDirection.isSameDirection(EAST_DIRECTION));
  }

  @Test
  void shouldMoveShouldReturnTrue() {
    var roverCommandResult = RoverCommandResult.builder().y(1).build();

    assertTrue(westDirection.shouldMove(roverCommandResult));
  }

  @Test
  void shouldMoveShouldReturnFalse() {
    var roverCommandResult = RoverCommandResult.builder().build();

    assertFalse(westDirection.shouldMove(roverCommandResult));
  }

  @Test
  void leftShouldReturnSouthDirection() {
    assertThat(westDirection.left()).isEqualTo(SOUTH_DIRECTION);
  }

  @Test
  void rightShouldReturnNorthDirection() {
    assertThat(westDirection.right()).isEqualTo(NORTH_DIRECTION);
  }

  @Test
  void moveShouldDecrementPosition() {
    var roverCommandResult = RoverCommandResult.builder().y(1).build();

    westDirection.move(roverCommandResult);

    assertThat(roverCommandResult).isEqualTo(RoverCommandResult.builder().y(0).build());
  }
}
