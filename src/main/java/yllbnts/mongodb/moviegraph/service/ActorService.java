package yllbnts.mongodb.moviegraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import yllbnts.mongodb.moviegraph.dto.ActorWithMoviesResponse;
import yllbnts.mongodb.moviegraph.model.Actor;
import yllbnts.mongodb.moviegraph.model.Movie;
import yllbnts.mongodb.moviegraph.repository.ActorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @author yelyzavetalubenets
 **/
@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Actor createActorAndAddToMovie(final Actor actor, final String movieId) {
        final Actor savedActor = actorRepository.save(actor);

        Query query = new Query(Criteria.where("_id").is(movieId));
        Update update = new Update().addToSet("actors", savedActor);

        mongoTemplate.updateFirst(query, update, Movie.class);

        return savedActor;
    }

    public Movie addActorToTheMovieBasedOnActorAndMovieNames(final List<String> actorsNames, final String movieName) {
        final String movieNameRegex = String.format(".*%s.*", movieName);

        Query movieQuery = new Query(Criteria.where("name").regex(movieNameRegex));
        actorsNames.forEach(actorName -> {
            final String actorNameRegex = Arrays.stream(actorName.trim().split("\\s+"))
                    .map(Pattern::quote)
                    .collect(Collectors.joining(".*", ".*", ".*"));

            Query actorQuery = new Query(Criteria.where("name").regex(actorNameRegex));
            final Actor actor = mongoTemplate.findOne(actorQuery, Actor.class);


            Update updateActorsSet = new Update().addToSet("actors", actor);
            mongoTemplate.updateFirst(movieQuery, updateActorsSet, Movie.class);
        });

        return mongoTemplate.findOne(movieQuery, Movie.class);
    }

    public Actor save(final Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public List<ActorWithMoviesResponse> findAcorsWithMovies() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.lookup("movies", "_id", "actors", "movies"));

        AggregationResults<ActorWithMoviesResponse> actorsWithMovies = mongoTemplate.aggregate(aggregation, "actors", ActorWithMoviesResponse.class);

        return actorsWithMovies.getMappedResults();
    }
}
