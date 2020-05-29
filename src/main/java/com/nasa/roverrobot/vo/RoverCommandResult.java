package com.nasa.roverrobot.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoverCommandResult {

  @Builder.Default
  private Integer y = 0;

  @Builder.Default
  private Integer x = 0;

  @Builder.Default
  private String direction = "N";
}
