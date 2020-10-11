package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

public class Comment
{
    @Id
    private String id;

    private User user;
    private String timestamp;
    private String commentContent;
    private Vote vote;

    Comment(){}

    public Comment(User user, String timestamp, String commentContent)
    {
        this.user = user;
        this.timestamp = timestamp;
        this.commentContent = commentContent;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getCommentContent()
    {
        return commentContent;
    }

    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent;
    }

    public Vote getVote()
    {
        return vote;
    }

    public void setVote(Vote vote)
    {
        this.vote = vote;
    }

    @Override
    public String toString()
    {
        return "Comment{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", timestamp='" + timestamp + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", vote=" + vote +
                '}';
    }
}
