package br.com.mongoblogs.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sections")
public class Section
{
    @Id
    protected ObjectId id;
    protected String title;
    protected String content;
    protected List<Section> sections;

    public Section()
    {
    }

    public Section(ObjectId id, String title, String content)
    {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Section(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Section(String title, String content, List<Section> sections)
    {
        this.title = title;
        this.content = content;
        this.sections = sections;
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public List<Section> getSections()
    {
        return sections;
    }

    public void setSections(List<Section> sections)
    {
        this.sections = sections;
    }

    @Override
    public String toString()
    {
        final String[] string = {"Section _id: " + id + " - " + title + ": " + content + "\n"};

        if (sections != null) {
            sections.forEach(section -> string[0] += section);
        }

        return string[0];
    }
}
