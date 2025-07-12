package yllbnts.mongodb.moviegraph.dto;

import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public record MovieActorNameRequest(List<String> actorsNames, String movieName) {
}
