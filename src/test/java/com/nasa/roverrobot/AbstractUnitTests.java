package com.nasa.roverrobot;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public abstract class AbstractUnitTests {

  @BeforeEach
  public final void setUpMocks() {
    MockitoAnnotations.initMocks(this);
  }
}
