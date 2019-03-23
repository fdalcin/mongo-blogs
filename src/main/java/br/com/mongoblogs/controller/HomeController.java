package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Scope("session")
public class HomeController
{
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/")
    public String index(ModelMap model)
    {
        List<Blog> blogs = this.blogRepository.findAllByOrderByLastPublishedDesc();

        model.addAttribute("blogs", blogs);

        return "index";
    }

}
