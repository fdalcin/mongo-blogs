package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class PostController
{
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/{id}/posts")
    public String show(@PathVariable("id") String id, ModelMap model)
    {
        Optional<Blog> result = blogRepository.findById(id);

        // TODO: orElse should redirect to 404 page

        return result.map(blog -> {
            model.addAttribute("blog", blog);

            //TODO: load posts for the blog
            return "/posts/list";
        }).orElse("redirect:/");
    }
}
