package famaly.people.servlet.controllers;

import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.services.AuthorisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/session")
public class AuthController {

    @Autowired
    private AuthorisationService authorisationService;

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

}
