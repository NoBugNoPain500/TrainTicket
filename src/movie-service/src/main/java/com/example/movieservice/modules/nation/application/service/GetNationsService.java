package com.example.movieservice.modules.nation.application.service;

import com.example.movieservice.modules.nation.application.dto.response.GetNationsResult;
import com.example.movieservice.modules.nation.application.dto.response.NationResult;
import com.example.movieservice.modules.nation.application.usecase.GetNationsUseCase;
import com.example.movieservice.modules.nation.domain.repository.NationRepository;

import java.util.List;

public class GetNationsService implements GetNationsUseCase {

    private final NationRepository nationRepository;

    public GetNationsService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    @Override
    public GetNationsResult execute() {
        List<NationResult> nations = nationRepository.getAll().stream()
                .map(
                        nation -> new NationResult(
                                nation.getNationId(),
                                nation.getNationName(),
                                nation.getNationCode()
                        )
                ).toList();
        return new GetNationsResult(nations);
    }
}
