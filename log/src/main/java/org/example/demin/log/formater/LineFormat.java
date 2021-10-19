package org.example.demin.log.formater;

import javax.inject.Singleton;

@Singleton
public final class LineFormat extends Format {
  public LineFormat() {
    super("Line %d: %s");
  }
}
