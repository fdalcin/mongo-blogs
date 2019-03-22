package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Post
{
    @Id
    private String id;
    private String title;
    private String blogId;
    private List<Section> sections;
    private Date publishedAt;

    public Post()
    {
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

    public String getPublishedAt()
    {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(publishedAt);
    }

    public void setPublishedAt(Date publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public String getBlogId()
    {
        return blogId;
    }

    public void setBlogId(String blogId)
    {
        this.blogId = blogId;
    }

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }
}
