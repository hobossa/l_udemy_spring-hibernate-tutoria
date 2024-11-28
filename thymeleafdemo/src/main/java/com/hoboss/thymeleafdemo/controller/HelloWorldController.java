package com.hoboss.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // show the initial HTML form
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm() {
        return "helloworld-form";
    }

    // process the HTML form
    @RequestMapping(value = "/processFormVersionV1")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        model.addAttribute("message", "Yo! " + name.toUpperCase());
        return "helloworld";
    }

    @PostMapping("/processFormVersionV3")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message", "Yo! " + name.toUpperCase());
        return "helloworld";
    }
}
