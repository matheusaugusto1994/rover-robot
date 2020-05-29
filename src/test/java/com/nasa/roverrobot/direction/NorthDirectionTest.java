package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.NORTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;

class NorthDirectionTest extends AbstractUnitTests {

  private final NorthDirection northDirection = new NorthDirection();

  @Test
  void isSameDirectionShouldReturnTrue() {
    assertTrue(northDirection.isSameDirection(NORTH_DIRECTION));
  }

  @Test
  void isSameDirectionShouldReturnFalse() {
    assertFalse(northDirection.isSameDirection(WEST_DIRECTION));
  }

  @Test
  void shouldMoveShouldReturnTrue() {
    var roverCommandResult = RoverCommandResult.builder().build();

    assertTrue(northDirection.shouldMove(roverCommandResult));
  }

  @Test
  void shouldMoveShouldReturnFalse() {
    var roverCommandResult = RoverCommandResult.builder().x(4).build();

    assertFalse(northDirection.shouldMove(roverCommandResult));
  }

  @Test
  void leftShouldReturnWestDirection() {
    assertThat(northDirection.left()).isEqualTo(WEST_DIRECTION);
  }

  @Test
  void rightShouldReturnEastDirection() {
    assertThat(northDirection.right()).isEqualTo(EAST_DIRECTION);
  }

  @Test
  void moveShouldIncrementPosition() {
    var roverCommandResult = RoverCommandResult.builder().build();

    northDirection.move(roverCommandResult);

    assertThat(roverCommandResult).isEqualTo(RoverCommandResult.builder().x(1).build());
  }
}
