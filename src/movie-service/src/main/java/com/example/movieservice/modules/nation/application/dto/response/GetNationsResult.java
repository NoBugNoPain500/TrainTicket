package com.example.movieservice.modules.nation.application.dto.response;

import java.util.List;

public record GetNationsResult(
        List<NationResult> nations
) {}
