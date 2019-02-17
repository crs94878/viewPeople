package famaly.people.servlet.controllers;

import famaly.people.servlet.exceptions.AuthorisationException;
import famaly.people.servlet.exceptions.SessionsValidationException;
import famaly.people.servlet.models.request.user.credentials.SessionCookies;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.models.response.front.SessionValidationResponse;
import famaly.people.servlet.services.AuthorisationService;
import famaly.people.servlet.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RequestMapping(path = "/session")
public class AuthController {

    @Autowired
    private AuthorisationService authorisationService;

    @Autowired
    private ValidationService validationService;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(path = "/auth", method = RequestMethod.POST)
    @ExceptionHandler(value = AuthorisationException.class)
    public @ResponseBody
    ResponseEntity<AuthSession> auth(@RequestBody Credentials requestAthh) throws AuthorisationException{
        try{
            AuthSession session = authorisationService.authorisation(requestAthh);
            return new ResponseEntity<>( session, HttpStatus.OK);
        }catch (Exception ex){
            throw new AuthorisationException("Ошибка авторизации");
        }
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(path ="/validation", method = RequestMethod.POST)
    @ExceptionHandler(value = SessionsValidationException.class)
    public @ResponseBody
    ResponseEntity<SessionValidationResponse> validation(@RequestBody SessionCookies cookies) throws SessionsValidationException{
        try{
            SessionValidationResponse session = validationService.validationSession(cookies);
            return new ResponseEntity<>(session, HttpStatus.OK);
        }catch (Exception ex){
           throw new SessionsValidationException("Сессия истекла и уже не валидна");
        }
    }
}
