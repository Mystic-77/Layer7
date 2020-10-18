package com.mystic.layer7.repository;

import com.mystic.layer7.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface PostRepository extends MongoRepository<Post, String>
{
    public List<Post> getPostsByUser(@Param("users") String user);
    public Post getPostById(@Param("postId") String postId);
}
