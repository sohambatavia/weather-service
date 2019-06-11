package au.origin.weather.application.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.origin.weather.application.CityServiceFacade;
import au.origin.weather.application.dto.CityDetails;
import au.origin.weather.domain.service.CityService;

@Service
public class DefaultCityServiceFacade extends AbstractApplicationServiceFacade implements CityServiceFacade {

    @Autowired
    private CityService cityService;

    @Override
    public List<CityDetails> getList() {

        return convert(cityService.getList(), CityDetails.class);
    }

}
