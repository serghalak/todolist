package academy.learnprogramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class DemoController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(">>>>>>>>>>>>>Hello");
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
