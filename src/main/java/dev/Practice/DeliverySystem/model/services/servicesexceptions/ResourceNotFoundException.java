package dev.Practice.DeliverySystem.model.services.servicesexceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found: Id: " + id);

    }

}
