package au.origin.weather.application.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CityDetails {

    private String name;
    private double temperature;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getTemperature() {

        return temperature;
    }

    public void setTemperature(double temperature) {

        this.temperature = temperature;
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
