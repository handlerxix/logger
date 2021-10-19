package org.example.demin.log.formater;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

@Singleton
public final class LineNumberFormatter {

  @NotNull
  public String formatString(@NotNull String str, @NotNull Integer num) {
    final var formatStr = "Line %d: %s";
    return String.format(formatStr, num, str);
  }
}
