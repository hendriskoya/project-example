package netgloo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Hendris on 9/8/2016.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CredenciadoNotFoundException extends RuntimeException {

    public CredenciadoNotFoundException(Long id) {
        super("could not find credenciado '" + id + "'");
    }
}
