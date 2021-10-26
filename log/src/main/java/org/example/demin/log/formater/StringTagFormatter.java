package org.example.demin.log.formater;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Objects;

@Singleton
public final class StringTagFormatter {

  @NotNull
  private final Format format;

  @Inject
  public StringTagFormatter(@NotNull Format format) {
    this.format = format;
  }

  @NotNull
  public String formatString(@NotNull String str) {
    final var formatStr = format.getFormat();
    final var formattedSting = String.format(formatStr, str);
    if (Objects.equals(formattedSting, formatStr) && !formatStr.isEmpty()) {
      System.out.println("Failed to apply format");
      return str;
    }
    return formattedSting;
  }
}
