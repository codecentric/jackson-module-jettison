package de.codecentric.jackson.module.jettison;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JettisonJacksonMapperProvider implements ContextResolver<ObjectMapper> {

  private final ObjectMapper mapper;

  public JettisonJacksonMapperProvider() {
    mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.ALWAYS);
    mapper.registerModule(new JettisonModule());
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return mapper;
  }
}
