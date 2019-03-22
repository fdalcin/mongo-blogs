package br.com.mongoblogs.repository;

import br.com.mongoblogs.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String>
{
    @Query("{'blogId': ?0}")
    List<Post> findByBlogId(String id, Sort sort);

    List<Post> findFirst5ByOrderByPublishedAtDesc();
}
