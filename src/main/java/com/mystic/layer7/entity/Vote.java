package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Vote
{
    @Id
    String id;

    private List<User> upvotes;
    private List<User> downvotes;
    private int votes;
    private String secondaryKey;

    public Vote()
    {
        this.votes = 0;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<User> getUpvotes()
    {
        return upvotes;
    }

    public void setUpvotes(List<User> upvotes)
    {
        this.upvotes = upvotes;
    }

    public List<User> getDownvotes()
    {
        return downvotes;
    }

    public void setDownvotes(List<User> downvotes)
    {
        this.downvotes = downvotes;
    }

    public int getVotes()
    {
        return votes;
    }

    public void setVotes(int votes)
    {
        this.votes = votes;
    }

    public String getSecondaryKey()
    {
        return secondaryKey;
    }

    public void setSecondaryKey(String secondaryKey)
    {
        this.secondaryKey = secondaryKey;
    }

    @Override
    public String toString()
    {
        return "Vote{" +
                "id='" + id + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", votes=" + votes +
                ", secondaryKey='" + secondaryKey + '\'' +
                '}';
    }
}
