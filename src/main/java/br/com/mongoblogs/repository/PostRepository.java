package br.com.mongoblogs.repository;

import br.com.mongoblogs.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByBlogId(String blogId);
}
