package org.example.demin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.demin.log.CombinedLogger;
import org.example.demin.log.ConsoleLogger;
import org.example.demin.log.FileLogger;
import org.example.demin.log.LoggerBase;
import org.example.demin.log.formater.Format;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public final class TestModule extends AbstractModule {
  @NotNull
  private final String[] args;

  @NotNull
  private static final Map<String, Class<? extends LoggerBase>> bindMap =
      Map.of("ConsoleLogger", ConsoleLogger.class,
          "FileLogger", FileLogger.class,
          "CombinedLogger", CombinedLogger.class);

  private static @NotNull
  String allLoggers() {
    final var loggers = bindMap.keySet().stream().reduce("", (res, logger) -> res += logger + ", ");
    return loggers.replaceAll("..$", "");
  }

  public TestModule(@NotNull String[] args) {
    if(args.length < 2 || bindMap.get(args[0]) == null){
      throw new IllegalArgumentException(
          "\nTwo application arguments must be provided:\n" +
              "\t1: Logger type. Available loggers: " + allLoggers() + ".\n" +
              "\t2: Formatting string: <{tag_name}>%s1</{tag_name}>\n"
      );
    }
    this.args = args;
  }

  @Override
  protected void configure() {
    final var logger = bindMap.get(args[0]);
    bind(LoggerBase.class).to(logger);

    final var tagFormat = new Format(args[1]);
    bind(Format.class).toInstance(tagFormat);
  }

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @Provides
  @NotNull
  public File provideFile() {
    final var fileFolderStr = Paths.get(".").toAbsolutePath().normalize().toString();
    final var fileNameStr = "logFile.txt";

    final var folder = new File(fileFolderStr);
    if (folder.exists()) {
      folder.delete();
      folder.mkdirs();
    }

    final var logFile = new File(String.format("%s\\%s", fileFolderStr, fileNameStr));
    if (!logFile.exists()) {
      try {
        logFile.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return logFile;
  }
}