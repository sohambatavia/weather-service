package au.origin.weather.domain.service.spi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import au.origin.weather.WeatherServiceDataUtils;
import au.origin.weather.domain.model.City;
import au.origin.weather.infrastructure.service.CityInfrastructureService;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCityServiceTest {

    @InjectMocks
    private DefaultCityService defaultCityService;

    @Mock
    private CityInfrastructureService cityService;

    @Test
    public void shouldGetCityList() {

        List<City> expectedCityList = Lists.newArrayList(WeatherServiceDataUtils.city());
        when(cityService.getList()).thenReturn(expectedCityList);
        List<City> cityList = defaultCityService.getList();
        assertEquals(expectedCityList.size(), cityList.size());
    }

}
