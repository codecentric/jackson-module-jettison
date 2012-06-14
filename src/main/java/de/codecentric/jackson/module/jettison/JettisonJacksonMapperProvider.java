package de.codecentric.jackson.module.jettison;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
public class JettisonJacksonMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public JettisonJacksonMapperProvider() {
	mapper = new ObjectMapper();
	mapper.registerModule(new JettisonModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
	return mapper;
    }
}
