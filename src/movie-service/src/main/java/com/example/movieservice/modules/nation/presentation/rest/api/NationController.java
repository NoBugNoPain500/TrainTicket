package com.example.movieservice.modules.nation.presentation.rest.api;

import com.example.movieservice.modules.nation.application.dto.request.AddNationCommand;
import com.example.movieservice.modules.nation.application.dto.request.EditNationCommand;
import com.example.movieservice.modules.nation.application.usecase.AddNationUseCase;
import com.example.movieservice.modules.nation.application.usecase.EditNationUseCase;
import com.example.movieservice.modules.nation.presentation.rest.dto.request.AddNationRequest;
import com.example.movieservice.modules.nation.presentation.rest.dto.request.EditNationRequest;
import com.example.movieservice.modules.shared.domain.annotations.SuccessResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.movieservice.modules.nation.application.dto.response.GetNationsResult;
import com.example.movieservice.modules.nation.application.usecase.GetNationsUseCase;
import com.example.movieservice.modules.nation.presentation.rest.dto.response.NationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Getter
public class NationController {

    private final GetNationsUseCase getNationService;
    private final AddNationUseCase addNationService;
    private final EditNationUseCase editNationService;

    @GetMapping("/nations")
    public ResponseEntity<List<NationResponse>> getAll() {
        GetNationsResult getNationsResult = getNationService.execute();
        return ResponseEntity.ok(
                getNationsResult.nations()
                        .stream()
                        .map(nationResult -> new NationResponse(
                                nationResult.nationId(),
                                nationResult.nationName(),
                                nationResult.nationCode()
                        ))
                        .toList()
        );
    }

    @PostMapping("nation")
    public ResponseEntity<Void> addNation(@RequestBody AddNationRequest request) {
        addNationService.execute(
                new AddNationCommand(
                        request.displayName(),
                        request.countryCode()
                )
        );

        return ResponseEntity.ok().build();
    }

    @PutMapping("nation/{id}")
    @SuccessResponse(message = "{nation.updated}")
    public ResponseEntity<Void> editNation(@PathVariable int id,
                                           @RequestBody EditNationRequest request) {
        editNationService.execute(
          new EditNationCommand(
                id,
                request.displayName(),
                request.countryCode()
          ));
        return ResponseEntity.ok().build();
    }

}
