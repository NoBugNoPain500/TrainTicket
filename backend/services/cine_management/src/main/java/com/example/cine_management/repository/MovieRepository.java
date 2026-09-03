package com.example.cine_management.repository;

import com.example.cine_management.entity.Movie;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@NullMarked
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Override
    Optional<Movie> findById(Integer integer);

    List<Movie> findAll();
}
