package br.com.mongoblogs.service;

import br.com.mongoblogs.model.Blog;
import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void save(Blog blog) throws Exception{
        blog.setId(null);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        blog.setUserId(user.getId());
        blog.setUsername(user.getUsername());

        blogValidate(blog);
        blogRepository.save(blog);
    }

    public void delete(Blog blog){
        blogRepository.delete(blog);
    }

    private void blogValidate(Blog blog) throws Exception{
        if(blog.getTitle() == null || blog.getTitle().isEmpty()){
            throw new Exception("Title of Blog is required.");
        }
        if(blog.getDescription() == null || blog.getDescription().isEmpty()){
            throw new Exception("Description of Blog is required.");
        }
        if(blog.getUserId() == null || blog.getUserId().isEmpty()){
            throw new Exception("Please sing in Mongo Blogs.");
        }
        if(blog.getUsername() == null || blog.getUsername().isEmpty()){
            throw new Exception("Please sing in Mongo Blogs.");
        }
    }

}
