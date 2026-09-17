package com.example.movieservice.modules.nation.presentation.rest.dto.request;

public record EditNationRequest(
        String displayName,
        String countryCode
) {
}
