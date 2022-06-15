package com.mongodb.userDetailsMongo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFound extends RuntimeException{

    private String resourceName;
    private String resource_field_nam;
    private Object resource_id;

    public resourceNotFound(String resourceName, String resource_field_nam, int resource_id) {
        super(String.format("%s not found in %s : '%s'",resourceName,resource_field_nam,resource_id));
        this.resourceName = resourceName;
        this.resource_field_nam = resource_field_nam;
        this.resource_id = resource_id;
    }
}
