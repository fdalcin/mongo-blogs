package br.com.mongoblogs.service;

import br.com.mongoblogs.model.Post;
import br.com.mongoblogs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void save(Post post, boolean edit) {
        if(!edit){
            post.setId(null);
        }

        post.setPublishedAt(Date.from(Instant.now()));

        postRepository.save(post);
    }
}
