package org.example.demin.log;

import org.example.demin.log.formater.LineNumberFormatter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public final class CombinedLogger extends LoggerBase {

  @NotNull
  private final ConsoleLogger consoleLogger;

  @NotNull
  private final FileLogger fileLogger;

  @Inject
  public CombinedLogger(@NotNull LineNumberFormatter formatter,
                        @NotNull LoggingStringCounter counter,
                        @NotNull ConsoleLogger consoleLogger,
                        @NotNull FileLogger fileLogger) {
    super(formatter, counter);
    this.consoleLogger = consoleLogger;
    this.fileLogger = fileLogger;
  }

  @Override
  public void log(@NotNull String str) {
    consoleLogger.log(str);
    fileLogger.log(str);
  }
}
