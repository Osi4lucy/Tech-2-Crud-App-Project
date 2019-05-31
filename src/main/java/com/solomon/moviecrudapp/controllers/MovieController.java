package com.solomon.moviecrudapp.controllers;

import com.solomon.moviecrudapp.entities.MovieEntity;
import com.solomon.moviecrudapp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {


    @Autowired
    private MovieRepository movieRepo;

    @GetMapping("/showMovie")
    public String movie(Model model){
        List<MovieEntity> movieList = movieRepo.findAllMovies();
        model.addAttribute("movies", movieList);
        return "showMovie";
    }

    @GetMapping (value="/addMovie")
    public String getMovie() {
        return "add-Movie";
    }
@GetMapping(value="/deleteMovie/{movie_id}")
    public String deleteMovie(@PathVariable(name="movie_id") int movie_id) {
        movieRepo.deleteMovies(movie_id);
        return "redirect:/showMovie";
    }
    @PostMapping("/addMovie")
    //@RequestParam("movie") String movie,
    public String addMovie(
            /* @RequestParam("movie_id") int movie_id, */
                             @RequestParam("movie_title") String movie_title,
                             @RequestParam("genre") String genre,
                             @RequestParam("year_of_release") int year_of_release,
                             @RequestParam("producer") String producer,
                             @RequestParam("rating") int rating,
                             @RequestParam("language") String language) {

        MovieEntity newMovie = new MovieEntity();

        newMovie.setMovie_title(movie_title);
        newMovie.setGenre(genre);
        newMovie.setYear_of_release(year_of_release);
        newMovie.setProducer(producer);
        newMovie.setRating(rating);
        newMovie.setLanguage(language);

        movieRepo.addMovie(newMovie);
        return "redirect:/showMovie";
    }

    @GetMapping("/editMovie/{id}")
    public String editMovie(Model m, @PathVariable(name = "id") int movie_id){
        MovieEntity movieToEdit = movieRepo.findMovie(movie_id);
        m.addAttribute("movieform", movieToEdit);
        return "edit-Movie";
    }

    @PostMapping("/update-movie")
    public String saveEditMovie(@ModelAttribute MovieEntity movie){
        movieRepo.update(movie);
        return "redirect:/showMovie";
    }
}
