package com.example.cine_management.service.cache;

import com.example.cine_management.entity.Movie;
import com.example.cine_management.errors.NotFoundObject;
import com.example.cine_management.pojo.BasicPersonDto;
import com.example.cine_management.pojo.MovieDetailDto;
import com.example.cine_management.repository.*;
import com.example.cine_management.repository.child.ChildMovieRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class MovieCacheService {

    private final ChildMovieRepository childMovieRepository;

    private final MovieRepository movieRepository;

    @Transactional
    @Cacheable(value = "movieDetail", key = "#id", unless = "#result == null")
    public MovieDetailDto getMovieDetail(Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow( () ->new NotFoundObject("Not found movie infos"));

        List<String> companies = childMovieRepository.getMovieCompanyRepository()
                .getMovieCompaniesByMovieId(id);

        List<String> genres = childMovieRepository.getMovieGenreRepository()
                .getMovieGenreByMovieId(id);

        List<String> nations = childMovieRepository.getMovieNationRepository()
                .getMovieNationByMovieId(id);

        List<BasicPersonDto> actors = childMovieRepository.getMovieActorRepository()
                .getActorsByMovieId(id);

        List<BasicPersonDto> directors = childMovieRepository.getMovieDirectorRepository()
                .getDirectorsByMovieId(id);

        return MovieDetailDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .actors(actors)
                .ageRatings(movie.getAgeRatings())
                .banner(movie.getBanner())
                .companies(companies)
                .description(movie.getDescription())
                .directors(directors)
                .genres(genres)
                .nations(nations)
                .rates(movie.getRates())
                .releaseDate(movie.getReleaseDate())
                .status(movie.getStatus())
                .trailer(movie.getTrailer())
                .votes(movie.getVotes())
                .voteSum(movie.getVoteSum())
                .build();
    }

}
