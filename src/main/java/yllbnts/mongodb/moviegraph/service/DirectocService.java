package yllbnts.mongodb.moviegraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import yllbnts.mongodb.moviegraph.model.Director;
import yllbnts.mongodb.moviegraph.model.Movie;
import yllbnts.mongodb.moviegraph.repository.DirectorRepository;

import java.util.List;


/**
 * @author yelyzavetalubenets
 **/
@Service
public class DirectocService {

    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Director createAndLinkDirectorToMovie(final Director director, final String movieId) {
        final Director savedDirector = directorRepository.save(director);

        Query query = new Query(Criteria.where("_id").is(movieId));
        Update update = new Update().set("director", savedDirector);

        mongoTemplate.updateFirst(query, update, Movie.class);

        return savedDirector;
    }

    public Director save(final Director director) {
        return directorRepository.save(director);
    }

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }
}
