package au.origin.weather.infrastructure.service.spi;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.origin.weather.config.TestConfiguration;
import au.origin.weather.domain.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class, DefaultCityInfrastructureService.class})
@TestPropertySource(locations = "classpath:application-test.properties")
public class DefaultCityInfrastructureServiceTest {

    @Autowired
    private DefaultCityInfrastructureService defaultCityInfrastructureService;

    @Test
    public void shouldGetList() {

        List<City> cityList = defaultCityInfrastructureService.getList();
        assertTrue(cityList.size() == 7);
    }

}
