
package au.origin.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@PropertySource("classpath:application-test.properties")
public class TestConfiguration {

    @Bean
    public ResourceLoader resourceLoader() {

        return new DefaultResourceLoader();
    }

    @Bean
    public ObjectMapper objectMapper() {

        return new ObjectMapper();
    }

}
