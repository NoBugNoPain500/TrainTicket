package com.example.cine_management.service;

import com.example.cine_management.common.ApiResponse;
import com.example.cine_management.mapstruct.MovieMapper;
import com.example.cine_management.pojo.BasicMovieDto;
import com.example.cine_management.pojo.MovieDetailDto;
import com.example.cine_management.service.cache.MovieCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieCacheService movieCacheService;

    public ApiResponse<MovieDetailDto> getMovieDetail(Integer id) {
        MovieDetailDto movieDetail = movieCacheService.getMovieDetail(id);

        return ApiResponse.<MovieDetailDto>success(
                201,
                movieDetail,
                "Get movie detail successfully"
        );
    }

    public ApiResponse<List<BasicMovieDto>> getMovieList() {
        List<BasicMovieDto> movieList = movieCacheService.getMovieRepository()
                .findAll()
                .stream().map(MovieMapper.INSTANCE::toDto)
                .toList();

        return ApiResponse.success(
                201,
                movieList,
                "Get movie list successfully"
        );
    }
}
