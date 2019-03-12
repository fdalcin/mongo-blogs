package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/register")
    public String blogRegister(Blog blog)
    {
        return "/blogs/register";
    }

    @PostMapping(value="/save", params = "action=save")
    public String save(Blog blog, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/blogs/register";
        }

        try{
            blogService.save(blog);
            attr.addFlashAttribute("success", "Blog registered with success!");
        }catch (Exception exc){
            attr.addFlashAttribute("fail", exc.getMessage());
        }

        return "redirect:/blogs/register";
    }

    @PostMapping(value="/save", params = "action=cancel")
    public String saveCancel(){
        return "redirect:/";
    }
}
