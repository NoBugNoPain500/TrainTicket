package com.example.movieservice.modules.nation.application.dto.request;

public record AddNationCommand(
        String nationName,
        String nationCode
) {
}
