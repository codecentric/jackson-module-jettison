package de.codecentric.jackson.module.jettison;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class JettisonModule extends SimpleModule {
    private final static String NAME = "JettisonModule";

    private final static Version VERSION = new Version(0, 0, 1, null);

    public JettisonModule() {
	super(NAME, VERSION);
	addDeserializer(JSONArray.class, JSONArrayDeserializer.instance);
	addDeserializer(JSONObject.class, JSONObjectDeserializer.instance);
	addSerializer(JSONArraySerializer.instance);
	addSerializer(JSONObjectSerializer.instance);
    }
}