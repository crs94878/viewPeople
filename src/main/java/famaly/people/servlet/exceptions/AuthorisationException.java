package famaly.people.servlet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AuthorisationException extends RuntimeException {

    public AuthorisationException(){super();}

    public AuthorisationException(String message){
        super(message);
    }

    public AuthorisationException(String message, Throwable cause){
        super(message,cause);
    }
}
