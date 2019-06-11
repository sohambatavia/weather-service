package au.origin.weather.application.dto.assembler;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import au.origin.weather.application.dto.CityDetails;
import au.origin.weather.domain.model.City;

@Component
public class CityToCityDetailsTransformer extends ModelConverter<City, CityDetails> {

    @Override
    public CityDetails convert(City city) {

        CityDetails cityDetails = new CityDetails();
        BeanUtils.copyProperties(city, cityDetails);
        return cityDetails;
    }
}
