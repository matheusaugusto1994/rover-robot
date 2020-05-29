package com.nasa.roverrobot.direction;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;

public class DirectionFilter {

  List<Direction> directions =
      Lists.newArrayList(
          new NorthDirection(), new SouthDirection(), new EastDirection(), new WestDirection());

  public Optional<Direction> filter(String direction) {
    return directions.stream()
        .filter(d -> d.isSameDirection(direction))
        .findFirst();
  }
}
