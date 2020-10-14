package com.mystic.layer7.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Vote
{
    @Id
    String id;

    private List<String> upvotes; //strings of user ids
    private List<String> downvotes; //strings of user ids
    private int votes;

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



    public int getVotes()
    {
        return votes;
    }

    public void setVotes(int votes)
    {
        this.votes = votes;
    }

    public List<String> getUpvotes()
    {
        return upvotes;
    }

    public void setUpvotes(List<String> upvotes)
    {
        this.upvotes = upvotes;
    }

    public List<String> getDownvotes()
    {
        return downvotes;
    }

    public void setDownvotes(List<String> downvotes)
    {
        this.downvotes = downvotes;
    }

    @Override
    public String toString()
    {
        return "Vote{" +
                "id='" + id + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", votes=" + votes +
                '}';
    }
}
