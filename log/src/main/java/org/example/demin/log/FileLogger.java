package org.example.demin.log;

import org.example.demin.log.formater.LineNumberFormatter;
import org.example.demin.log.formater.StringTagFormatter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class FileLogger extends LoggerBase {

  @NotNull
  private final FileOutputStream fileStream;

  @NotNull
  private final StringTagFormatter tagFormatter;

  @Inject
  public FileLogger(@NotNull LineNumberFormatter lineNumberFormatter,
                    @NotNull LoggingStringCounter counter,
                    @NotNull File logFile,
                    @NotNull StringTagFormatter tagFormatter) throws FileNotFoundException {
    super(lineNumberFormatter, counter);
    this.fileStream = new FileOutputStream(logFile);
    this.tagFormatter = tagFormatter;
  }

  @Override
  public void log(@NotNull String str) {
    try {
      final var tagFormatted = tagFormatter.formatString(str);
      final var lineFormatted = formatter.formatString(tagFormatted, counter.getNumber()) + "\n";
      fileStream.write(lineFormatted.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
