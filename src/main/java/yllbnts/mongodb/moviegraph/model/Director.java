package yllbnts.mongodb.moviegraph.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Document(collection = "directors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"target", "source"})
public class Director {
    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
}
