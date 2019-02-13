package famaly.people.servlet.controllers;

import famaly.people.servlet.models.request.user.credentials.SessionCookies;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.models.response.front.SessionValidationResponse;
import famaly.people.servlet.services.AuthorisationService;
import famaly.people.servlet.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/session")
public class AuthController {

    @Autowired
    private AuthorisationService authorisationService;

    @Autowired
    private ValidationService validationService;

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(path = "/auth", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<AuthSession> auth(@RequestBody Credentials requestAthh){
        try{
            AuthSession session = authorisationService.authorisation(requestAthh);
            return new ResponseEntity<>( session, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(path ="/validation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<SessionValidationResponse> validation(@RequestBody SessionCookies cookies){
        //try{
            SessionValidationResponse session = validationService.validationSession(cookies);
            return new ResponseEntity<>(session, HttpStatus.OK);
       // }catch (Exception ex){
           // System.out.println(ex.getMessage());
         //   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //}
    }
}
