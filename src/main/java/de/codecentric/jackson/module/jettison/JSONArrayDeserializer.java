package de.codecentric.jackson.module.jettison;

import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JSONArrayDeserializer extends StdDeserializer<JSONArray> {
    public final static JSONArrayDeserializer instance = new JSONArrayDeserializer();

    public JSONArrayDeserializer() {
	super(JSONArray.class);
    }

    @Override
    public JSONArray deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
	    JsonProcessingException {
	JSONArray array = new JSONArray();
	JsonToken t;
	while ((t = jp.nextToken()) != JsonToken.END_ARRAY) {
	    switch (t) {
	    case START_ARRAY:
		array.put(deserialize(jp, ctxt));
		continue;
	    case START_OBJECT:
		array.put(JSONObjectDeserializer.instance.deserialize(jp, ctxt));
		continue;
	    case VALUE_STRING:
		array.put(jp.getText());
		continue;
	    case VALUE_NULL:
		array.put(JSONObject.NULL);
		continue;
	    case VALUE_TRUE:
		array.put(Boolean.TRUE);
		continue;
	    case VALUE_FALSE:
		array.put(Boolean.FALSE);
		continue;
	    case VALUE_NUMBER_INT:
		array.put(jp.getNumberValue());
		continue;
	    case VALUE_NUMBER_FLOAT:
		array.put(jp.getNumberValue());
		continue;
	    case VALUE_EMBEDDED_OBJECT:
		array.put(jp.getEmbeddedObject());
		continue;
	    }
	    throw ctxt.mappingException("Urecognized or unsupported JsonToken type: " + t);
	}
	return array;
    }
}
