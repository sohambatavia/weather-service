package au.origin.weather.application.dto.assembler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.origin.weather.WeatherServiceDataUtils;
import au.origin.weather.application.dto.CityDetails;
import au.origin.weather.domain.model.City;

public class CityToCityDetailsTransformerTest {

    @Test
    public void shouldTrnasformFromCityToCityDetails() {

        CityDetails cityDetails = new CityDetails();
        City city = WeatherServiceDataUtils.city();
        CityToCityDetailsTransformer cityDetailsTransformer = new CityToCityDetailsTransformer();
        cityDetails = cityDetailsTransformer.convert(city);

        assertEquals(city.getName(), cityDetails.getName());
        assertEquals(city.getTemperature(), cityDetails.getTemperature(), 0);

    }

}
