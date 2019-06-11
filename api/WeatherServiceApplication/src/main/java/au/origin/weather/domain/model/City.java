package au.origin.weather.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class City {

    private String name;
    private double temperature;

    City() {
    }

    City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {

        return name;
    }

    public double getTemperature() {

        return temperature;
    }

    @Override
    public boolean equals(Object object) {

        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this);
    }
}
