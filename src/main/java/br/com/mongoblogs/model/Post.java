package br.com.mongoblogs.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Post
{
    @Id
    protected ObjectId id;
    protected String title;
    protected List<Section> sections;
    protected Date publishedAt;

    public Post()
    {
    }

    public Post(ObjectId id, String title, List<Section> sections, Date publishedAt)
    {
        this.id = id;
        this.title = title;
        this.sections = sections;
        this.publishedAt = publishedAt;
    }

    public Post(String title, List<Section> sections, Date publishedAt)
    {
        this.title = title;
        this.sections = sections;
        this.publishedAt = publishedAt;
    }

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
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

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }

    public String getPublishedAt()
    {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(publishedAt);
    }

    public void setPublishedAt(Date publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString()
    {
        final String[] string = {"Post _id: " + id + " - " + title + ": " + publishedAt + "\n"};

        sections.forEach(section -> string[0] += section);

        return string[0];
    }
}
