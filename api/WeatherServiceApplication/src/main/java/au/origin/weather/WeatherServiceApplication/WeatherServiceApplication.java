package au.origin.weather.WeatherServiceApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "au.origin.weather")
public class WeatherServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(WeatherServiceApplication.class, args);
    }
}
