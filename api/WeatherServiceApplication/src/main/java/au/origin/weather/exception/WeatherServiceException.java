package au.origin.weather.exception;

public class WeatherServiceException extends RuntimeException {

    public WeatherServiceException() {
        super();
    }

    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherServiceException(String message) {
        super(message);
    }

    public WeatherServiceException(Throwable cause) {
        super(cause);
    }
}
