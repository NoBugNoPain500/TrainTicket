package com.example.movieservice.modules.movie.domain.repository;

import com.example.movieservice.modules.movie.domain.entity.Movie;

public interface MovieRepository {

    void save(Movie movie);

    Movie findById(Integer movieId);
}
