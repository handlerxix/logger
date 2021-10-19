package org.example.demin.log;

import org.example.demin.log.formater.LineNumberFormatter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public abstract class LoggerBase {

  @NotNull
  protected final LineNumberFormatter formatter;

  @NotNull
  protected final LoggingStringCounter counter;

  @Inject
  protected LoggerBase(@NotNull LineNumberFormatter formatter, @NotNull LoggingStringCounter counter) {
    this.formatter = formatter;
    this.counter = counter;
  }

  public abstract void log(@NotNull String str);
}
