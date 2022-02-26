package com.mato.movie_mato.springRepository;

import java.util.List;

import com.mato.movie_mato.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository< Movie, Long > {
    List<Movie> findMovieByActor(String name);
} 
