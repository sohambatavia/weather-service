package au.origin.weather.application;

import java.util.List;

import au.origin.weather.application.dto.CityDetails;

public interface CityServiceFacade {

    List<CityDetails> getList();
}
