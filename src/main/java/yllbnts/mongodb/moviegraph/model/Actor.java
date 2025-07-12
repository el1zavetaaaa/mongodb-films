package yllbnts.mongodb.moviegraph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author yelyzavetalubenets
 **/
@Document(collection = "actors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Actor {
    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
}
