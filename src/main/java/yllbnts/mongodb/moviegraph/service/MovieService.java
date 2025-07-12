package yllbnts.mongodb.moviegraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yllbnts.mongodb.moviegraph.dto.MovieRequest;
import yllbnts.mongodb.moviegraph.model.Movie;
import yllbnts.mongodb.moviegraph.repository.MovieRepository;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie save(final MovieRequest movieRequest) {
        final Movie movie = new Movie();
        movie.setName(movieRequest.name());
        movie.setYear(movieRequest.year());
        movie.setGenres(movieRequest.genres());
        return movieRepository.save(movie);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}
