package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.EAST_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.SOUTH_DIRECTION;
import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nasa.roverrobot.AbstractUnitTests;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;

class SouthDirectionTest extends AbstractUnitTests {

  private final SouthDirection southDirection = new SouthDirection();

  @Test
  void isSameDirectionShouldReturnTrue() {
    assertTrue(southDirection.isSameDirection(SOUTH_DIRECTION));
  }

  @Test
  void isSameDirectionShouldReturnFalse() {
    assertFalse(southDirection.isSameDirection(WEST_DIRECTION));
  }

  @Test
  void shouldMoveShouldReturnTrue() {
    var roverCommandResult = RoverCommandResult.builder().x(1).build();

    assertTrue(southDirection.shouldMove(roverCommandResult));
  }

  @Test
  void shouldMoveShouldReturnFalse() {
    var roverCommandResult = RoverCommandResult.builder().build();

    assertFalse(southDirection.shouldMove(roverCommandResult));
  }

  @Test
  void leftShouldReturnEastDirection() {
    assertThat(southDirection.left()).isEqualTo(EAST_DIRECTION);
  }

  @Test
  void rightShouldReturnWestDirection() {
    assertThat(southDirection.right()).isEqualTo(WEST_DIRECTION);
  }

  @Test
  void moveShouldDecrementPosition() {
    var roverCommandResult = RoverCommandResult.builder().x(1).build();

    southDirection.move(roverCommandResult);

    assertThat(roverCommandResult).isEqualTo(RoverCommandResult.builder().x(0).build());
  }
}
