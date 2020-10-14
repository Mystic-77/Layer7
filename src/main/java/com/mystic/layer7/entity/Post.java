package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;

public class Post
{
    @Id
    private String id;

    private String user;
    private String title;
    private String content;
    private String timestamp;

    private String vote;
    private List<String> comments;
    private List<String> tags;
    public Post(){}

    public Post(String user, String title, String content, String timestamp)
    {
        this.user = user;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
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

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getVote()
    {
        return vote;
    }

    public void setVote(String vote)
    {
        this.vote = vote;
    }

    public List<String> getComments()
    {
        return comments;
    }

    public void setComments(List<String> comments)
    {
        this.comments = comments;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    @Override
    public String toString()
    {
        return "Post{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", vote='" + vote + '\'' +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }
}
