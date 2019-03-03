package br.com.mongoblogs.repository;

import br.com.mongoblogs.model.User;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MongoUserDetailsRepository implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String usernamep) throws UsernameNotFoundException {

        MongoDatabase database = mongoClient.getDatabase("blogs");
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = collection.find(Filters.eq("username",usernamep)).first();

        if(document!=null) {
            String username = document.getString("username");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");

            User user = new User(username, password, authorities.toArray(new String[authorities.size()]));

            return user;
        }

        return null;
    }
}
