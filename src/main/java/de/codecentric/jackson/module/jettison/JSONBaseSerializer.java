package de.codecentric.jackson.module.jettison;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

abstract class JSONBaseSerializer<T> extends StdSerializer<T> {
  protected JSONBaseSerializer(Class<T> cls) {
    super(cls);
  }
}
