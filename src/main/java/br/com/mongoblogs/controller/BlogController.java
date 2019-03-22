package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController
{

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/register")
    public String blogRegister(Blog blog)
    {
        return "/blogs/register";
    }

    @GetMapping("/edit/{id}")
    public String preEdit(@PathVariable("id") String id, ModelMap model)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Blog blog = blogRepository.findById(id).get();

        if (!blog.getUsername().equals(user.getUsername())) {
            return "redirect:/";
        }

        model.addAttribute("blog", blog);
        return "/blogs/register";
    }

    @GetMapping("/list")
    public String blogList(ModelMap model)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Blog> blogs = blogRepository.findByUsername(user.getUsername());
        model.addAttribute("blogs", blogs);

        return "/blogs/list";
    }

    @PostMapping(value = "/save", params = "action=save")
    public String save(@Valid Blog blog, BindingResult result, RedirectAttributes attr)
    {
        if (result.hasErrors()) {
            return "/blogs/register";
        }

        try {
            boolean edit;
            if (blog.getId() != null && !blog.getId().isEmpty()) {
                edit = true;
            } else {
                edit = false;
            }

            blogService.save(blog, edit);
            attr.addFlashAttribute("success", "Blog registered with success!");
        } catch (Exception exc) {
            attr.addFlashAttribute("fail", exc.getMessage());
        }

        return "redirect:/blogs/register";
    }

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
