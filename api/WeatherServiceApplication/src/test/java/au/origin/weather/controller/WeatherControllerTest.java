package au.origin.weather.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import au.origin.weather.application.CityServiceFacade;
import au.origin.weather.application.dto.CityDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WeatherControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CityServiceFacade cityServiceFacade;

    @InjectMocks
    private WeatherController weatherController;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(weatherController)
                .build();
    }

    @Test
    public void shouldGetList() throws Exception {

        CityDetails cityDetails = new CityDetails();
        cityDetails.setName("Melbourne");
        cityDetails.setTemperature(23.45d);
        List<CityDetails> cityDetais = Lists.newArrayList(cityDetails);

        when(cityServiceFacade.getList()).thenReturn(cityDetais);
        this.mockMvc.perform(get("/temperature/city"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name': 'Melbourne','temperature': 23.45}]"));
    }

}
