package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

public class Link
{
    @Id
    private String id;

    private String groupName;
    private String description;
    private String link;

    public Link(){}

    public Link(String groupName, String description, String link)
    {
        this.groupName = groupName;
        this.description = description;
        this.link = link;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    @Override
    public String toString()
    {
        return "Link{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
