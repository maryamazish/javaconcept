package com.azish.designpatterns.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class SingletonTest {

  @Test
  void getInstance_Success() {
    Singleton singleton = Singleton.getInstance();
    assertNotNull(singleton);
    var singleton2 = Singleton.getInstance();
    assertEquals(singleton, singleton2);
  }

  @Test
  void getInstance_Success2(@Mock Singleton singletonMock) {
    //Singleton singleton1 = mock(Singleton.class);
    Singleton singleton = Singleton.getInstance();
    assertNotNull(singleton);
    assertNotEquals(singleton, singletonMock);
  }
}
