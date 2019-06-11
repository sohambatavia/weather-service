package au.origin.weather.application.spi;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import au.origin.weather.WeatherServiceDataUtils;
import au.origin.weather.application.dto.CityDetails;
import au.origin.weather.application.dto.ObjectAssembler;
import au.origin.weather.domain.model.City;
import au.origin.weather.domain.service.CityService;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCityServiceFacadeTest {

    @Mock
    private CityService cityService;

    @Mock
    private ObjectAssembler assembler;

    @InjectMocks
    private DefaultCityServiceFacade defaultCityServiceFacade;

    @Test
    public void shouldGetCityList() {

        List<City> cityList = Lists.newArrayList(WeatherServiceDataUtils.city());
        when(cityService.getList()).thenReturn(cityList);

        for (City city : cityList) {

            CityDetails cityDetails = new CityDetails();
            cityDetails.setName(city.getName());
            cityDetails.setTemperature(city.getTemperature());

            when(assembler.assemble(city, CityDetails.class, new String[0])).thenReturn(cityDetails);
        }

        List<CityDetails> cityDetailsList = defaultCityServiceFacade.getList();
        assertTrue(cityDetailsList.size() == 1);

    }

}
