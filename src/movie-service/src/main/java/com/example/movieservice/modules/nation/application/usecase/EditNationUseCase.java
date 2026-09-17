package com.example.movieservice.modules.nation.application.usecase;

import com.example.movieservice.modules.nation.application.dto.request.EditNationCommand;

public interface EditNationUseCase {
    void execute(EditNationCommand command);
}
