package org.example.demin;

import com.google.inject.Guice;
import org.example.demin.log.LoggerBase;
import org.jetbrains.annotations.NotNull;

public final class Application {
  public static void main(@NotNull String[] args) {
    final var injector = Guice.createInjector(new TestModule(args));

    final var logger = injector.getInstance(LoggerBase.class);
    logger.log("Keks");
    logger.log("Ukrop");
  }
}
