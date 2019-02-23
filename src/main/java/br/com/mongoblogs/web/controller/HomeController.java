package br.com.mongoblogs.web.controller;

import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class HomeController
{
    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/")
    public String index()
    {

        User user = new User();

        user.setFirstname("Felipe");
        user.setLastname("Dalcin");
        user.setUsername("fdalcin");

        this.userRepository.save(user);

        return "index";
    }
}
