package br.com.mongoblogs.service;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.Post;
import br.com.mongoblogs.repository.BlogRepository;
import br.com.mongoblogs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BlogRepository blogRepository;

    public void save(Post post, boolean edit) {
        if(!edit){
            post.setId(null);
        }

        post.setPublishedAt(Date.from(Instant.now()));

        postRepository.save(post);

        Blog blog = blogRepository.findById(post.getBlogId()).get();
        blog.setLastPublished(Date.from(Instant.now()));

        blogRepository.save(blog);
    }
}
