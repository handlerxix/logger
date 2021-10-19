package org.example.demin.log.formater;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class Format {
  @NotNull
  @Getter
  private final String format;

  public Format(@NotNull String format) {
    this.format = format;
  }
}
