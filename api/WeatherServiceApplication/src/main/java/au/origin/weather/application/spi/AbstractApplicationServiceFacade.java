package au.origin.weather.application.spi;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import au.origin.weather.application.dto.ObjectAssembler;

abstract class AbstractApplicationServiceFacade {

    @Autowired
    private ObjectAssembler assembler;

    protected <T> List<T> convert(Collection<?> list, Class<T> type) {

        List<T> newList = Lists.newArrayList();
        list.forEach(item -> newList.add(assemble(item, type)));
        return newList;
    }

    protected final <T> T assemble(Object sourceObject, Class<T> destinationClass, String... ignoreProperties) {

        return assembler.assemble(sourceObject, destinationClass, ignoreProperties);
    }

}
