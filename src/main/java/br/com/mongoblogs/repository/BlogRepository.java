package br.com.mongoblogs.repository;

import br.com.mongoblogs.model.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BlogRepository extends MongoRepository<Blog, String>
{
    @Query("{'user._id': ?0}")
    List<Blog> findByUser(ObjectId id);
}
