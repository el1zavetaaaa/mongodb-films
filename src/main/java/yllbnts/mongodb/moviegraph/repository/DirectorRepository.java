package yllbnts.mongodb.moviegraph.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yllbnts.mongodb.moviegraph.model.Director;

/**
 * @author yelyzavetalubenets
 **/
public interface DirectorRepository extends MongoRepository<Director, String> {
}
