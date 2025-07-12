package yllbnts.mongodb.moviegraph.dto;

import yllbnts.mongodb.moviegraph.model.Movie;

import java.time.LocalDate;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public record ActorWithMoviesResponse(String id,
                                      String name,
                                      LocalDate birthDate,
                                      List<Movie> movies) {
}
