package famaly.people.view.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ViewController {

    @RequestMapping(path = "/peoples/save/{token}")
    public String getIndexPage(@PathVariable String token, Map<String, Object>model){
        return "saveNewPeople";
    }
}
