package br.com.mongoblogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @GetMapping("/register")
    public String index()
    {
        return "/blogs/register";
    }
}
