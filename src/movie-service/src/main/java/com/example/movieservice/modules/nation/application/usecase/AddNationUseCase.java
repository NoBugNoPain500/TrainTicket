package com.example.movieservice.modules.nation.application.usecase;

import com.example.movieservice.modules.nation.application.dto.request.AddNationCommand;

public interface AddNationUseCase {
    void execute(AddNationCommand command);
}
