package com.mystic.layer7.repository;

import com.mystic.layer7.entity.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface LinkRepository extends MongoRepository<Link, String>
{

}
