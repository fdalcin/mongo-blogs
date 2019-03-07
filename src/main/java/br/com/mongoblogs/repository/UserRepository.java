package br.com.mongoblogs.repository;

import br.com.mongoblogs.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends MongoRepository<User, String>
{
    User findById(ObjectId id);
    
    User findByUsername(String username);
}
