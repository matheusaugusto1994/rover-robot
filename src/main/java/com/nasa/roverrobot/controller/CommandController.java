package com.nasa.roverrobot.controller;

import com.nasa.roverrobot.service.CommandService;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

  @Autowired
  private CommandService commandService;

  @PostMapping(value = "/mars/{command}")
  public RoverCommandResult post(@PathVariable String command) {
    return commandService.executeCommand(command);
  }
}
