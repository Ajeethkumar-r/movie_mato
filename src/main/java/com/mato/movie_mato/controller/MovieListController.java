package com.mato.movie_mato.controller;

import java.util.List;

import com.mato.movie_mato.model.Movie;
import com.mato.movie_mato.springRepository.MovieListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MovieListController {

    @Autowired
    private MovieListRepository movieListRepository;

    // @RequestMapping (method = RequestMethod.GET,  value = "/movies/{actorName}")
    @GetMapping("/movies/{actorName}")
    public String getMovieList( @PathVariable("actorName") String name, Model model) {

        List <Movie> movieList =   movieListRepository.findMovieByActor(name);

        model.addAttribute("movies", movieList);        

        return "movieList";
    }

    @RequestMapping( method = RequestMethod.POST, value = "/movies", consumes = "application/json" )
    public ResponseEntity<Object> addMovies( @RequestBody Movie movie){
        // we don't need to write seperate method for post jpaRepository by default provide "save"
        movieListRepository.save(movie);
        return ResponseEntity.ok().build();
    }
}
