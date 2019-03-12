package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.Post;
import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.repository.PostRepository;
import br.com.mongoblogs.service.PostService;
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

@Controller
@RequestMapping("/posts")
public class PostController
{
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @PostMapping(value="/save", params = "action=save")
    public String save(@Valid Post post, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "redirect:/posts/register/"+post.getBlogId();
        }

        boolean edit;
        if(post.getId() != null && !post.getId().isEmpty()){
            edit = true;
        }else{
            edit = false;
        }

        postService.save(post,edit);
        attr.addFlashAttribute("success", "Post registered with success!");

        return "redirect:/posts/register/"+post.getBlogId();
    }

    @GetMapping("/register/{blogId}")
    public String postRegister(Post post, @PathVariable("blogId") String blogId, ModelMap model)
    {
        Blog blog = blogRepository.findById(blogId).get();
        post.setBlogId(blog.getId());
        model.addAttribute("post", post);
        return "/posts/register";
    }

    @GetMapping("/edit/{id}")
    public String preEdit(@PathVariable("id") String id, ModelMap model) {
        Post post = postRepository.findById(id).get();
        Blog blog = blogRepository.findById(post.getBlogId()).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!blog.getUsername().equals(user.getUsername())){
            return "redirect:/";
        }

        model.addAttribute("post", post);
        return "/posts/register";
    }

    @GetMapping("/list/{id}")
    public String listBlogPost(@PathVariable("id") String id, ModelMap model) {
        Blog blog = blogRepository.findById(id).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!blog.getUsername().equals(user.getUsername())){
            return "redirect:/";
        }

        List<Post> posts = postRepository.findByBlogId(id);

        model.addAttribute("posts", posts);
        model.addAttribute("blog", blog);

        return "/posts/list";
    }

}
