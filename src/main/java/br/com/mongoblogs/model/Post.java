package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Post
{
    @Id
    protected String id;
    protected String title;
    protected List<Session> sessions;
    protected Date publishedAt;

    public Post()
    {
    }

    public Post(String id, String title, List<Session> sessions, Date publishedAt)
    {
        this.id = id;
        this.title = title;
        this.sessions = sessions;
        this.publishedAt = publishedAt;
    }

    public Post(String title, List<Session> sessions, Date publishedAt)
    {
        this.title = title;
        this.sessions = sessions;
        this.publishedAt = publishedAt;
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

    public List<Session> getSessions()
    {
        return sessions;
    }

    public void setSessions(List<Session> sessions)
    {
        this.sessions = sessions;
    }

    public Date getPublishedAt()
    {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt)
    {
        this.publishedAt = publishedAt;
    }
}
