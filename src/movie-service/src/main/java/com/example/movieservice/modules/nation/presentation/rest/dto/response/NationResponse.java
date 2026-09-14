package com.example.movieservice.modules.nation.presentation.rest.dto.response;

public record NationResponse(
        int countryId,
        String displayName,
        String countryCode
) {
}
