package yllbnts.mongodb.moviegraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yllbnts.mongodb.moviegraph.dto.MovieActorNameRequest;
import yllbnts.mongodb.moviegraph.dto.MovieRequest;
import yllbnts.mongodb.moviegraph.model.Actor;
import yllbnts.mongodb.moviegraph.model.Director;
import yllbnts.mongodb.moviegraph.model.Movie;
import yllbnts.mongodb.moviegraph.service.ActorService;
import yllbnts.mongodb.moviegraph.service.DirectocService;
import yllbnts.mongodb.moviegraph.service.MovieService;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private DirectocService directocService;

    @GetMapping
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @PostMapping("/add")
    private Movie addMovie(@RequestBody MovieRequest movieRequest) {
        return movieService.save(movieRequest);
    }

    @PostMapping("/{movieId}/actors")
    public Actor createAndLinkActor(@PathVariable String movieId, @RequestBody Actor actor) {
        return actorService.createActorAndAddToMovie(actor, movieId);
    }

    @PostMapping("/{movieId}/directors")
    public Director createAndLinkDirector(@PathVariable String movieId, @RequestBody Director director) {
        return directocService.createAndLinkDirectorToMovie(director, movieId);
    }

    @PostMapping("/actors/by-name")
    public Movie addActorToMovieByTheirNames(@RequestBody MovieActorNameRequest movieActorNameRequest) {
        return actorService.addActorToTheMovieBasedOnActorAndMovieNames(movieActorNameRequest.actorsNames(), movieActorNameRequest.movieName());
    }

}
