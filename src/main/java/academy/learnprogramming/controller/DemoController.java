package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    //@Autowired
    private DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(">>>>>>>>>>>>>Hello");
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(@RequestParam String user
                          ,@RequestParam int age, Model model ){
        //model.addAttribute("user","Tim");
        model.addAttribute("helloMessage"
                ,demoService.getHelloMessage(user));
        //model.addAttribute("welcomeMessage",demoService.getWelcomeMessage());
        model.addAttribute("age",age);
        log.info("model={}",model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        //return "Welcome to this Demo application.";
        return demoService.getWelcomeMessage();
    }

}
