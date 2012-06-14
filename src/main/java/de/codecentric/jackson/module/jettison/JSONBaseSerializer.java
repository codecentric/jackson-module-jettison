package de.codecentric.jackson.module.jettison;

import org.codehaus.jackson.map.ser.std.SerializerBase;

abstract class JSONBaseSerializer<T> extends SerializerBase<T> {
    protected JSONBaseSerializer(Class<T> cls) {
	super(cls);
    }
}
