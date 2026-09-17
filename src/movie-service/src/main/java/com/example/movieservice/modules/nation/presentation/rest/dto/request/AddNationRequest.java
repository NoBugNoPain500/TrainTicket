package com.example.movieservice.modules.nation.presentation.rest.dto.request;

public record AddNationRequest(
        String displayName,
        String countryCode
) {
}
