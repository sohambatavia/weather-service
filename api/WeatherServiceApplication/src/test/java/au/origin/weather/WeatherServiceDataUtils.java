package au.origin.weather;

import org.springframework.test.util.ReflectionTestUtils;

import au.origin.weather.domain.model.City;
import au.origin.weather.domain.model.DomainObjectFactoryTestUtils;

public final class WeatherServiceDataUtils {

    public static City city() {

        City city = entity(City.class);

        ReflectionTestUtils.setField(city, "name", "Sydney");
        ReflectionTestUtils.setField(city, "temperature", 2.55d);

        return city;
    }

    public static <T> T entity(Class<T> type) {

        return DomainObjectFactoryTestUtils.create(type);
    }

}
