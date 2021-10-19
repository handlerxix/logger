package org.example.demin.log;

import com.google.inject.Singleton;
import org.jetbrains.annotations.NotNull;

@Singleton
public final class LoggingStringCounter {
  @NotNull
  private Integer counter = 0;

  @NotNull
  public Integer getNumber() {
    return ++counter;
  }
}
