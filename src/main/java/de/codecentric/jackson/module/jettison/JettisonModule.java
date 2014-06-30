package de.codecentric.jackson.module.jettison;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JettisonModule extends SimpleModule {

  private static final long serialVersionUID = 1L;

  private final static String NAME = "JettisonModule";

  private final static Version VERSION = new Version(0, 0, 8, null, "de.codecentric", "jackson-module-jettison");

  public JettisonModule() {
    super(NAME, VERSION);
    addDeserializer(JSONArray.class, JSONArrayDeserializer.instance);
    addDeserializer(JSONObject.class, JSONObjectDeserializer.instance);
    addSerializer(JSONArraySerializer.instance);
    addSerializer(JSONObjectSerializer.instance);
  }
}