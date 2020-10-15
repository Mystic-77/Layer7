package com.mystic.layer7.repository;

import com.mystic.layer7.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends MongoRepository<User, String>
{
    public User getUserByUsername(@Param("username") String username);
    public User getUserById(@Param("Id") String id);
}
