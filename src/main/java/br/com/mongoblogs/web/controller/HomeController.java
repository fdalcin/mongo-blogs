package br.com.mongoblogs.web.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Scope("session")
public class HomeController
{
    @GetMapping("/")
    public String index(Model view)
    {
        return "index";
    }
}
