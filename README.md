# mongodb-films

## You could store film info there 🎬🎥

## Technologies used

+ MongoDB
+ Spring Boot MongoDb Data Starter
+ Spring Boot Web Starter

## Key aspects
+ mappings using **@DocumentReference** in a <ins>**Movie.class**</ins>
+ adding mapped data using **MongoTemplate** in <ins>**ActorService.class**</ins> and <ins>**DirectorService.class**</ins>
+ using **Aggregation** to map movies actors were filmed in <ins>**ActorService.class**</ins>

### To create a movie entity 📀
+ make request to _**/movies/add**_
> { <br>
"name": "Barbie", <br>
"year": 2024, \
"genres": ["COMEDY", "DRAMA"] \
}
### To create an actor entity 🧑‍🎨
+ make request to _**/actors/add**_
> { <br>
"name": "Margot Elise Robbie", \
"birthDate": "1990-07-01" \
> }

### To add created actor to the movie 🧑‍🎨📀
+ make request to _**/movies/actors/by-name**_
> { <br>
"actorsNames": ["Margot Robbie"],\
"movieName": "Barbie"\
> }

### To create an actor and <ins>immediately</ins>❗️ add it to movie 🧑‍🎨📀❗️
+ make request to _**/movies/{movieId}/actors**_
> { <br>
"name": "Ryan Thomas Gosling", \
"birthDate": "1980-11-11" \
> }

### To create a director entity 👩‍💻
+ make request to _**/directors/add**_
> { <br>
"name": "Greta Celeste Gerwig",\
"birthDate": "1983-08-03"\
> }

### To create a director and <ins>immediately</ins>❗️ add it to movie 👩‍💻📀❗️
+ make request to _**/movies/{movieId}/directors**_
> { <br>
"name": "Greta Celeste Gerwig",\
"birthDate": "1983-08-03"\
> }

### To select movies 📀📀📀
+ make request to _**/movies**_

### To select actors 🧑‍🎨🧑‍🎨🧑‍🎨
+ make request to _**/actors**_

### To select actors with the movies they were filmed in 🧑‍🎨📀🧑‍🎨📀🧑‍🎨📀
+ make request to _**/actors/with-movies**_

### To select directors 👩‍💻👩‍💻👩‍💻
+ make request to _**/directors**_