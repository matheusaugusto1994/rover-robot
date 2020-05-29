package com.nasa.roverrobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class AbstractControllerTests extends AbstractUnitTests {

  @Autowired
  protected MockMvc mvc;

}
