package famaly.people.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutorizationController {

    @RequestMapping(path="/page/auth")
    public String getAuthpage(){
        return "authPage";
    }
}
