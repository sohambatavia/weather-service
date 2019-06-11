package au.origin.weather.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestErrorHandler {

    private static final String MESSAGE = "Please contact to administrator";
    private static final Log LOG = LogFactory.getLog(RestErrorHandler.class);

    @ExceptionHandler(WeatherServiceException.class)
    public ResponseEntity<?> handleWeatherServiceException(Exception ex, WebRequest webRequest) {

        LOG.debug("Error processing request WeatherServiceException:: " + ex.getMessage(), ex);
        ApplicationErrorDetails errorDetails = new ApplicationErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGE, ex.getMessage() + webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest webRequest) {

        LOG.debug("Error processing request :: " + ex.getMessage(), ex);
        ApplicationErrorDetails errorDetails = new ApplicationErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGE, ex.getMessage() + webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
