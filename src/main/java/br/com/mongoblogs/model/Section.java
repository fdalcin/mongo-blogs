package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sections")
public class Section
{
    @Id
    private String id;
    private String title;
    private String content;
    private List<Section> sections;

    public Section()
    {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
