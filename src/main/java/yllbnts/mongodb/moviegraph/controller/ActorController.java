package yllbnts.mongodb.moviegraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yllbnts.mongodb.moviegraph.dto.ActorWithMoviesResponse;
import yllbnts.mongodb.moviegraph.model.Actor;
import yllbnts.mongodb.moviegraph.service.ActorService;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping()
    public List<Actor> findAllActors() {
        return actorService.findAllActors();
    }

    @GetMapping("/with-movies")
    public List<ActorWithMoviesResponse> findAllActorsWithMovies() {
        return actorService.findAcorsWithMovies();
    }

    @PostMapping("/add")
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

}
