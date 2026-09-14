package com.example.movieservice.modules.nation.application.dto.response;

public record NationResult(
        Integer nationId,
        String nationName,
        String nationCode
) {
}
