package com.example.movieservice.modules.movie.infrastructure.persistence.impl;

import com.example.movieservice.modules.movie.domain.entity.Movie;
import com.example.movieservice.modules.movie.domain.repository.MovieRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Override
    public void save(Movie movie) {

    }

    @Override
    public Movie findById(Integer movieId) {
        return null;
    }
}
