package com.mystic.layer7;


import com.mystic.layer7.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private VoteRepository voteRepository;

    DatabaseService(){}

    public UserRepository getUserRepository()
    {
        return userRepository;
    }

    public CommentRepository getCommentRepository()
    {
        return commentRepository;
    }

    public LinkRepository getLinkRepository()
    {
        return linkRepository;
    }

    public PlaylistRepository getPlaylistRepository()
    {
        return playlistRepository;
    }

    public PostRepository getPostRepository()
    {
        return postRepository;
    }

    public VoteRepository getVoteRepository()
    {
        return voteRepository;
    }
}
