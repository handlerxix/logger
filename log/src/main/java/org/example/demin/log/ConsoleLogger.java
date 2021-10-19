package org.example.demin.log;

import org.example.demin.log.formater.LineNumberFormatter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public final class ConsoleLogger extends LoggerBase {

  @Inject
  public ConsoleLogger(@NotNull LineNumberFormatter formatter, @NotNull LoggingStringCounter counter) {
    super(formatter, counter);
  }

  @Override
  public void log(@NotNull String str) {
    System.out.println(formatter.formatString(str, counter.getNumber()));
  }
}
