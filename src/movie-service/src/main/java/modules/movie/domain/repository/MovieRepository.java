package modules.movie.domain.repository;

import modules.movie.domain.entity.Movie;

public interface MovieRepository {

    void save(Movie movie);

    Movie findById(Integer movieId);
}
