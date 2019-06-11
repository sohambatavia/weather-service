package au.origin.weather.application.dto;

public interface ObjectAssembler {

    <T> T assemble(Object sourceObject, Class<T> destinationClass, String... ignoreProperties);
}
