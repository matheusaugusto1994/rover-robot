package com.nasa.roverrobot.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nasa.roverrobot.AbstractControllerTests;
import com.nasa.roverrobot.service.CommandService;
import com.nasa.roverrobot.vo.RoverCommandResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(CommandController.class)
class CommandControllerTest extends AbstractControllerTests {

  @MockBean
  private CommandService commandService;

  @Test
  void testPostMarsEndpoint() throws Exception {
    when(commandService.executeCommand(anyString()))
        .thenReturn(RoverCommandResult.builder().build());

    mvc.perform(
        post("/mars/MML"))
    .andExpect(status().isOk());
  }
}
