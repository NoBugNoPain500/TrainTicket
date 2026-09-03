package com.example.cine_management.controller;

import com.example.cine_management.common.ApiResponse;
import com.example.cine_management.pojo.BasicMovieDto;
import com.example.cine_management.pojo.MovieDetailDto;
import com.example.cine_management.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<ApiResponse<MovieDetailDto>> getMovieDetail(@PathVariable Integer id) {

        ApiResponse<MovieDetailDto> movieDetail = movieService.getMovieDetail(id);

        return ResponseEntity.ok(
                movieDetail
        );
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<BasicMovieDto>>> getMovieList() {
        ApiResponse<List<BasicMovieDto>> movieList = movieService.getMovieList();

        return ResponseEntity.ok(
                movieList
        );
    }
}
