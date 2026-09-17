package com.example.movieservice.modules.nation.application.dto.request;

public record EditNationCommand(
        int nationId,
        String nationName,
        String nationCode
) {
}
