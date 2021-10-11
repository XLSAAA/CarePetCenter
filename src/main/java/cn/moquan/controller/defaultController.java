package cn.moquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/default")
public class defaultController {

    @RequestMapping("/method01")
    public String method01(){



        return "success";
    }

    @RequestMapping("/toindex")
    public String method02(){

        return "redirect:/index.html";
    }

    @RequestMapping("/toindex2")
    public String method03(){

        return "redirect:/index2.html";
    }

}
