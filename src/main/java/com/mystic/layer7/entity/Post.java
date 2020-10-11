package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;

public class Post
{
    @Id
    private String id;

    private User author;
    private String title;
    private String content;
    private String timestamp;

    private Vote vote;
    private List<Comment> comments;

    public Post(){}

    public Post(User author, String title, String content, String timestamp)
    {
        this.author = author;
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

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
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

    public Vote getVote()
    {
        return vote;
    }

    public void setVote(Vote vote)
    {
        this.vote = vote;
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "Post{" +
                "id='" + id + '\'' +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", vote=" + vote +
                ", comments=" + comments +
                '}';
    }
}
