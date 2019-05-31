package com.solomon.moviecrudapp.repositories;

import com.solomon.moviecrudapp.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {


    @Autowired
    private JdbcTemplate jdbc;

    public int addMovie(MovieEntity movieEntity) {
        String sqlQuery = "INSERT INTO movie(movie_title, genre, year_of_release, producer, rating, language) VALUES (?,?,?,?,?,?)";
        return jdbc.update(sqlQuery, movieEntity.getMovie_title(), movieEntity.getGenre(), movieEntity.getYear_of_release(), movieEntity.getProducer(), movieEntity.getRating(), movieEntity.getLanguage());
    }

    public List<MovieEntity> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie");
        List<MovieEntity> movieList = new ArrayList<>();
        while (rs.next()) {
            MovieEntity movie = new MovieEntity();
            movie.setMovie_id(rs.getInt("movie_id"));
            movie.setMovie_title(rs.getString("movie_title"));
            movie.setGenre(rs.getString("genre"));
            movie.setYear_of_release(rs.getInt("year_of_release"));
            movie.setProducer(rs.getString("producer"));
            movie.setRating(rs.getInt("rating"));
            movie.setLanguage(rs.getString("language"));

            movieList.add(movie);
        }
        return movieList;
    }

public void deleteMovies(int movie_id) {
        jdbc.update("DELETE FROM movie WHERE movie_id =" + movie_id);
    }

    public MovieEntity findMovie(int id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE movie_id = " + id);
        MovieEntity movie = new MovieEntity();
        while (rs.next()) {

            setMovie(movie, rs);

        }
        return movie;
    }

    public void update(MovieEntity movie) {
        jdbc.update("UPDATE movie SET " +
                "movie_title='" + movie.getMovie_title() + "', " +
                "genre='" + movie.getGenre() + "', " +
                "year_of_release='" + movie.getYear_of_release() + "', " +
                "producer='" + movie.getProducer() + "', " +
                "rating='" + movie.getRating() + "', " +
                "language='" + movie.getLanguage() + "' " +
                "WHERE movie_id=" + movie.getMovie_id());
    }

    public MovieEntity setMovie(MovieEntity movie, SqlRowSet rs) {

        movie.setMovie_id(rs.getInt("movie_id"));
        movie.setMovie_title(rs.getString("movie_title"));
        movie.setGenre(rs.getString("genre"));
        movie.setYear_of_release(rs.getInt("year_of_release"));
        movie.setProducer(rs.getString("producer"));
        movie.setRating(rs.getInt("rating"));
        movie.setLanguage(rs.getString("language"));

        return movie;
    }
}
