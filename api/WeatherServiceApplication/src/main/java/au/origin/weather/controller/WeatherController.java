package au.origin.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.origin.weather.application.CityServiceFacade;
import au.origin.weather.application.dto.CityDetails;

@RestController
public class WeatherController {

    @Autowired
    private CityServiceFacade cityServiceFacade;

    @RequestMapping(value = "/temperature/city", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<CityDetails>> cityList() {

        return new ResponseEntity<>(cityServiceFacade.getList(), HttpStatus.OK);
    }
}
