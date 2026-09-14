package com.example.movieservice.modules.nation.presentation.rest.api;

import com.example.movieservice.modules.shared.domain.annotations.ResponseInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.movieservice.modules.nation.application.dto.response.GetNationsResult;
import com.example.movieservice.modules.nation.application.usecase.GetNationsUseCase;
import com.example.movieservice.modules.nation.presentation.rest.dto.response.NationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Getter
public class NationController {

    private final GetNationsUseCase getNationService;

    @GetMapping("/nations")
    @ResponseInfo(message = "Success", businessCode = 1000)
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
}
