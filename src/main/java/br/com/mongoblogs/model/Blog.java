package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "blogs")
public class Blog implements Serializable
{
    @Id
    private String id;
    private String title;
    private String description;
    private User user;
    private List<Post> posts;

    public Blog()
    {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString()
    {
        final String[] string = {"Blog _id: " + id + " - " + title + ": " + description + "\n"};
        string[0] += "Owner: " + user.getFullname() + "\n\n";

        posts.forEach(post -> string[0] += post);

        return string[0];
    }
}
