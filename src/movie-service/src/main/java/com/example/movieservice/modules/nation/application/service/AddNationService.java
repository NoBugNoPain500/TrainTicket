package com.example.movieservice.modules.nation.application.service;

import com.example.movieservice.modules.nation.application.dto.request.AddNationCommand;
import com.example.movieservice.modules.nation.application.usecase.AddNationUseCase;
import com.example.movieservice.modules.nation.domain.entity.Nation;
import com.example.movieservice.modules.nation.domain.repository.NationRepository;

public class AddNationService implements AddNationUseCase {

    private final NationRepository nationRepository;

    public AddNationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    @Override
    public void execute(AddNationCommand command) {
        nationRepository.save(
                new Nation(
                        null,
                        command.nationName(),
                        command.nationCode()
                )
        );
    }
}
