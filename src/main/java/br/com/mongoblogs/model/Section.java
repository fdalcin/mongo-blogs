package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sections")
public class Section
{
    @Id
    private String id;
    private String title;
    private String content;
    private String postId;
    private String parentSectionId;

    public Section()
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getPostId()
    {
        return postId;
    }

    public void setPostId(String postId)
    {
        this.postId = postId;
    }

    public String getParentSectionId()
    {
        return parentSectionId;
    }

    public void setParentSectionId(String parentSectionId)
    {
        this.parentSectionId = parentSectionId;
    }
}
