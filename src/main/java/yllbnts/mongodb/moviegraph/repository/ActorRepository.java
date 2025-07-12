package yllbnts.mongodb.moviegraph.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yllbnts.mongodb.moviegraph.model.Actor;

/**
 * @author yelyzavetalubenets
 **/
public interface ActorRepository extends MongoRepository<Actor, String> {
}
