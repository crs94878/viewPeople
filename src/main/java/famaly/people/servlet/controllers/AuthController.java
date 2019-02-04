package famaly.people.servlet.controllers;

import famaly.people.servlet.models.AuthSession;
import famaly.people.servlet.models.Credentials;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/session")
public class AuthController {

    @RequestMapping(path = "/auth")
    public @ResponseBody AuthSession auth(@RequestBody Credentials requestAthh){
        
    }

}
