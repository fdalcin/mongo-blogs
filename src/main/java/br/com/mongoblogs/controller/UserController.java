package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.User;
import br.com.mongoblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(User user)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && !"anonymousUser".equals(authentication.getPrincipal())){
            return "redirect:/";
        }

        return "/users/register";
    }

    @GetMapping("/edit")
    public String preEdit(ModelMap model)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "/users/register";
    }

    @PostMapping(value="/save", params = "action=save")
    public String save(@Valid User user, @RequestParam("passwordConfirm") String passwordConfirm, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "redirect:/users/register";
        }

        try{
            boolean edit;
            if(user.getId() != null && !user.getId().isEmpty()){
                edit = true;
            }else{
                edit = false;
            }

            userService.save(user, passwordConfirm, edit);

            attr.addFlashAttribute("success", "User registered with success!");
        }catch (Exception exc){
            attr.addFlashAttribute("fail", exc.getMessage());
        }

        return "redirect:/users/register";
    }
}
