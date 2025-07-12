package yllbnts.mongodb.moviegraph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    private String _id;
    private String name;
    private int year;
    private List<Genre> genres;
    @DocumentReference
    private List<Actor> actors;
    @DocumentReference(lazy = true)
    private Director director;
}
