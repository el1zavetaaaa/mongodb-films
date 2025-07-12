package yllbnts.mongodb.moviegraph.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yllbnts.mongodb.moviegraph.model.Movie;

/**
 * @author yelyzavetalubenets
 **/
public interface MovieRepository extends MongoRepository<Movie, String> {
}
