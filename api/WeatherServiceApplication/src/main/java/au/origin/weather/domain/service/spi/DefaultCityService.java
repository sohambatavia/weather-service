package au.origin.weather.domain.service.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.origin.weather.domain.model.City;
import au.origin.weather.domain.service.CityService;
import au.origin.weather.infrastructure.service.CityInfrastructureService;

@Service
public class DefaultCityService implements CityService {

    @Autowired
    private CityInfrastructureService cityService;

    @Override
    public List<City> getList() {

        return cityService.getList();
    }
}
