package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.User;
import br.com.mongoblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(User user)
    {
        return "/users/register";
    }

    @PostMapping("/save")
    public String save(User user, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "users/register";
        }

        userService.save(user);
        return "redirect:/";
    }

}
