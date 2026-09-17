package com.example.movieservice.modules.nation.application.service;

import com.example.movieservice.modules.nation.application.dto.request.EditNationCommand;
import com.example.movieservice.modules.nation.application.usecase.EditNationUseCase;
import com.example.movieservice.modules.nation.domain.entity.Nation;
import com.example.movieservice.modules.nation.domain.repository.NationRepository;

public class EditNationService implements EditNationUseCase {

    private final NationRepository nationRepository;

    public EditNationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    @Override
    public void execute(EditNationCommand command) {
        nationRepository.save(
            new Nation(
                    command.nationId(),
                    command.nationName(),
                    command.nationCode()
            )
        );
    }
}
