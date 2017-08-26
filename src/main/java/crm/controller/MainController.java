package crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by acer1 on 2017/6/14.
 */
@Controller
public class MainController {
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
