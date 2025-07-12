package yllbnts.mongodb.moviegraph.dto;

import yllbnts.mongodb.moviegraph.model.Genre;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/

public record MovieRequest(String name, int year, List<Genre> genres) {
}
