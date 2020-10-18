package com.mystic.layer7.repository;

import com.mystic.layer7.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface CommentRepository extends MongoRepository<Comment, String>
{
    public List<Comment> getCommentByPost(@Param("postid") String postid);
    public void deleteCommentsByPost(@Param("postid")String postid);
}
