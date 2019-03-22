package br.com.mongoblogs.controller;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.Post;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController
{
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blogs/{id}/posts")
    public String list(@PathVariable("id") String id, ModelMap model)
    {
        Optional<Blog> optionalBlog = blogRepository.findById(id);

        // TODO: orElse should redirect to 404 page
        return optionalBlog.map(blog -> {
            List<Post> posts = postRepository.findByBlogId(blog.getId(), new Sort(Sort.Direction.DESC, "publishedAt"));
            List<Post> recentPosts = postRepository.findFirst5ByOrderByPublishedAtDesc();

            model.addAttribute("blog", blog);

            model.addAttribute("posts", posts);
            model.addAttribute("recentPosts", recentPosts);

            return "/posts/list";
        }).orElse("redirect:/");
    }

    @GetMapping("/post/{id}")
    public String show(@PathVariable("id") String id, ModelMap model)
    {
        Optional<Post> optionalPost = postRepository.findById(id);

        // TODO: orElse should redirect to 404 page
        return optionalPost.map(post -> {
            Optional<Blog> blog = blogRepository.findById(post.getBlogId());
            List<Post> recentPosts = postRepository.findFirst5ByOrderByPublishedAtDesc();

            model.addAttribute("post", post);
            model.addAttribute("blog", blog.orElse(null));
            model.addAttribute("recentPosts", recentPosts);

            return "/posts/show";
        }).orElse("redirect:/");
    }
}
