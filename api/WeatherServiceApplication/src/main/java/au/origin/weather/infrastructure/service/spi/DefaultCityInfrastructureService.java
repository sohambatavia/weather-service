package au.origin.weather.infrastructure.service.spi;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import au.origin.weather.domain.model.City;
import au.origin.weather.exception.WeatherServiceException;
import au.origin.weather.infrastructure.dto.JsonWrapper;
import au.origin.weather.infrastructure.service.CityInfrastructureService;

@Service
public class DefaultCityInfrastructureService implements CityInfrastructureService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${origin.weather-result.file-path}")
    private String filePath;

    @Override
    public List<City> getList() {

        List<City> cities = Lists.newArrayList();

        try {
            File file = resourceLoader.getResource(filePath).getFile();
            JsonWrapper jsonWrapper = objectMapper.readValue(file, new TypeReference<JsonWrapper>() {
            });

            if (!CollectionUtils.isEmpty(jsonWrapper.getList())) {

                for (Map<String, Object> map : jsonWrapper.getList()) {
                    City city = objectMapper.convertValue(map, City.class);
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            throw new WeatherServiceException(e.getMessage(), e);
        }

        return cities;
    }

}
