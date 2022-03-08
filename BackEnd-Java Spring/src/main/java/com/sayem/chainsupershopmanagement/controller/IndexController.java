
package com.sayem.chainsupershopmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping(value = "/")
    public String welcome(){
        return "index";
    }
}
