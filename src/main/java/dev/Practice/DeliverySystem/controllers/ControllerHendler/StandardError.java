package dev.Practice.DeliverySystem.controllers.ControllerHendler;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable{
    @Serial 
    private final long serialVersionUID = 1L;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //"moment": "2019-06-20T19:53:07","moment": "2019-06-20T19:53:07",
    private Instant timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public StandardError(){
        
    }

    public StandardError(Instant timestamp, HttpStatus status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;

        this.message = message;
        this.path = path;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    

}
