package yllbnts.mongodb.moviegraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yllbnts.mongodb.moviegraph.model.Director;
import yllbnts.mongodb.moviegraph.service.DirectocService;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectocService directocService;

    @GetMapping
    public List<Director> findAllDirectors() {
        return directocService.findAllDirectors();
    }

    @PostMapping("/add")
    public Director addDirector(@RequestBody Director director) {
        return directocService.save(director);
    }
}
