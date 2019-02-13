package famaly.people.view.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/peoples")
public class ViewControllerView {

    @CrossOrigin
    @RequestMapping(path = "/view")
    public String getIndexPage( Map<String, Object>model){
        return "saveNewPeople";
    }
}
