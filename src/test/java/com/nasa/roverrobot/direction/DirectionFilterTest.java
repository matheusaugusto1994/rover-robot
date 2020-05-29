package com.nasa.roverrobot.direction;

import static com.nasa.roverrobot.utils.Constants.WEST_DIRECTION;
import static org.assertj.core.api.Assertions.assertThat;

import com.nasa.roverrobot.AbstractUnitTests;
import org.junit.jupiter.api.Test;

class DirectionFilterTest extends AbstractUnitTests {

  private final DirectionFilter directionFilter = new DirectionFilter();

  @Test
  void shouldFilter() {
    assertThat(directionFilter.filter(WEST_DIRECTION)).isPresent();
  }

  @Test
  void filterShouldNotFoundDirection() {
    assertThat(directionFilter.filter("M")).isNotPresent();
  }
}
