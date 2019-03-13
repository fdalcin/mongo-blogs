package br.com.mongoblogs.model;

import java.util.List;

public class Section
{
    private String title;
    private String content;
    private List<Section> subSections;

    public Section()
    {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Section> getSubSections() {
        return subSections;
    }

    public void setSubSections(List<Section> subSections) {
        this.subSections = subSections;
    }
}
