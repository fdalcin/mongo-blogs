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
    @Autowired
    protected UserRepository users;

    @Autowired
    protected BlogRepository blogs;

    @GetMapping("/")
    public String index(Model view)
    {
//        this.blogs.deleteAll();
//        this.users.deleteAll();

//        User user = new User("Yan", "Venera", "yanalexander", "secret");

//        this.users.save(user);

//        List<Post> posts = new ArrayList();
//        List<Section> sections = new ArrayList();
//        List<Section> subsessions = new ArrayList();

//        subsessions.add(new Section("2.1. Tópico dentro de conteúdo", "Conteúdo do tópico 2.1"));
//        subsessions.add(new Section("2.2. Tópico dentro de conteúdo", "Conteúdo do tópico 2.2"));

//        sections.add(new Section("1. Introdução", "Conteúdo da primeira seção do post"));
//        sections.add(new Section("2. Conteúdo", "Seção dividida em subseções", subsessions));
//        sections.add(new Section("3. Conclusão", "Seção de conclusão"));

//        posts.add(new Post("Segundo post do blog", sections, new Date()));

//        Blog blog = new Blog(
//                "Segundo Blog",
//                "Blog de exemplo para criação de aplicação com MongoDB",
//                user,
//                posts
//        );

//        this.blogs.save(blog);

//        List<Blog> blogs = this.blogs.findAll();
//        User user = this.users.findAll().get(0);
//
//        List<Blog> blogs = this.blogs.findByUser(user.getId());
//        System.out.println(user.getFullname());
//        blogs.forEach(blog -> System.out.println(blog.getId() + " - " + blog.getTitle()));
//
//        List<Blog> blogs = this.blogs.findByTitle();
//
        List<Blog> blogs = this.blogs.findAll(
                new Sort(Sort.Direction.DESC, "posts.publishedAt")
        );

        view.addAttribute("blogs", blogs);

        blogs.forEach(blog -> System.out.println(blog));

        return "index";
    }
}
