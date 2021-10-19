package org.example.demin;

import com.google.inject.Guice;
import org.example.demin.log.LoggerBase;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class Application {
  public static void main(@NotNull String[] args) {
    final var injector = Guice.createInjector(new TestModule(args));

    final var logger = injector.getInstance(LoggerBase.class);

    final var reader = new Scanner(System.in);

    for (int i = 0; i < 10; i++) {
      System.out.print("\nEnter log-string: ");
      logger.log(reader.nextLine());
    }
  }
}
