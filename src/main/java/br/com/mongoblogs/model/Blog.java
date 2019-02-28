package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "blogs")
public class Blog
{
    @Id
    protected String id;
    protected String title;
    protected String description;
    protected User user;
    protected List<Post> posts;

    public Blog()
    {
    }

    public Blog(String id, String title, String description, User user, List<Post> posts)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.posts = posts;
    }

    public Blog(String title, String description, User user, List<Post> posts)
    {
        this.title = title;
        this.description = description;
        this.user = user;
        this.posts = posts;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }
}
