package au.origin.weather.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApplicationErrorDetails implements Serializable {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String details;

    public ApplicationErrorDetails(HttpStatus status, String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public ApplicationErrorDetails(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ApplicationErrorDetails() {
    }

    public HttpStatus getStatus() {

        return status;
    }

    public LocalDateTime getTimestamp() {

        return timestamp;
    }

    public String getMessage() {

        return message;
    }

    public String getDetails() {

        return details;
    }

}
