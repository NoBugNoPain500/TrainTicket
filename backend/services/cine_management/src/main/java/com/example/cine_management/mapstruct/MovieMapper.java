package com.example.cine_management.mapstruct;

import com.example.cine_management.entity.Movie;
import com.example.cine_management.pojo.BasicMovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    BasicMovieDto toDto(Movie movie);
}
