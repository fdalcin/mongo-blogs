package br.com.mongoblogs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sessions")
public class Session
{
    @Id
    protected String id;
    protected String title;
    protected String content;
    protected List<Session> sessions;

    public Session()
    {
    }

    public Session(String id, String title, String content)
    {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Session(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Session(String title, String content, List<Session> sessions)
    {
        this.title = title;
        this.content = content;
        this.sessions = sessions;
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

    public List<Session> getSessions()
    {
        return sessions;
    }

    public void setSessions(List<Session> sessions)
    {
        this.sessions = sessions;
    }
}
