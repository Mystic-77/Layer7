package com.mystic.layer7.repository;

import com.mystic.layer7.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CommentRepository extends MongoRepository<Comment, String>
{

}
