package org.example.demin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.demin.log.LoggerBase;
import org.example.demin.log.formater.Format;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public final class TestModule extends AbstractModule {
  @NotNull
  private final String[] args;

  public TestModule(@NotNull String[] args) {
    this.args = args;
  }

  @Override
  protected void configure() {
    try {
      final var logger = Class.forName(args[0]);
      bind(LoggerBase.class).to((Class<? extends LoggerBase>) logger);

      final var tagFormat = new Format(args[1]);
      bind(Format.class).toInstance(tagFormat);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
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