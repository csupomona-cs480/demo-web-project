package edu.csupomona.cs480.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavbarController {

    @RequestMapping("/")
    String index() {
        return "index";
    }
    
    @RequestMapping("/create")
    String create() {
    	return "index";
    }
}
