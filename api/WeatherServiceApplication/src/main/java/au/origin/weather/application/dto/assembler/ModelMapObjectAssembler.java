package au.origin.weather.application.dto.assembler;

import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.origin.weather.application.dto.ObjectAssembler;

@Component
public class ModelMapObjectAssembler implements ObjectAssembler {

    private ModelMapper modelMapper;

    @Autowired(required = false)
    private List<ModelConverter<?, ?>> converters;

    public ModelMapObjectAssembler() {

        modelMapper = new ModelMapper();
    }

    @Override
    public <T> T assemble(Object sourceObject, Class<T> destinationClass, String... ignoreProperties) {

        return modelMapper.map(sourceObject, destinationClass);
    }

    @PostConstruct
    void initialise() {

        if (converters != null) {

            converters.forEach(converter -> modelMapper.addConverter(converter));
        }

    }

}
