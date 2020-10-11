package com.mystic.layer7.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PlaylistRepository extends MongoRepository<PlaylistRepository, String>
{

}
