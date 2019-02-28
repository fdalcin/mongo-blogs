package br.com.mongoblogs.web.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.Post;
import br.com.mongoblogs.model.Session;
import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class HomeController
{
    @Autowired
    protected UserRepository users;

    @Autowired
    protected BlogRepository blogs;

    @GetMapping("/")
    public String index()
    {
//        this.blogs.deleteAll();
//        this.users.deleteAll();
//
//        User user = new User(null, "Felipe", "Dalcin", "fdalcin", "secret");
//
//        this.users.save(user);
//
//        List<Post> posts = new ArrayList();
//        List<Session> sessions = new ArrayList();
//        List<Session> subsessions = new ArrayList();
//
//        subsessions.add(new Session("2.1. Tópico dentro de conteúdo", "Conteúdo do tópico 2.1"));
//        subsessions.add(new Session("2.2. Tópico dentro de conteúdo", "Conteúdo do tópico 2.2"));
//
//        sessions.add(new Session("1. Introdução", "Conteúdo da primeira seção do post"));
//        sessions.add(new Session("2. Conteúdo", "Seção dividida em subseções", subsessions));
//        sessions.add(new Session("3. Conclusão", "Seção de conclusão"));
//
//        posts.add(new Post("Primeiro post do blog", sessions, new Date()));
//
//        Blog blog = new Blog(
//                "Primeiro Blog",
//                "Blog de exemplo para criação de aplicação com MongoDB",
//                user,
//                posts
//        );
//
//        this.blogs.save(blog);

//        List<Blog> blogs = this.blogs.findAll();
//        User user = this.users.findAll().get(0);
//
//        List<Blog> blogs = this.blogs.findByUser(user.getId());
//        System.out.println(user.getFirstname() + ' ' + user.getLastname());
//        blogs.forEach(blog -> System.out.println(blog.getTitle()));

        return "index";
    }
}
