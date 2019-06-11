package au.origin.weather.infrastructure.service;

import java.util.List;

import au.origin.weather.domain.model.City;

public interface CityInfrastructureService {

    List<City> getList();
}
