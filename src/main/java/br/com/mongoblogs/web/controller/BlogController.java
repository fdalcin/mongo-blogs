package br.com.mongoblogs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {


    @GetMapping("/cadastrar")
    public String index()
    {
        return "/blogs/cadastro";
    }
}
