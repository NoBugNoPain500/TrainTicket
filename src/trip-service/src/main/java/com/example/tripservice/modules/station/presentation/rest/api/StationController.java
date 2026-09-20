package com.example.tripservice.modules.station.presentation.rest.api;

import com.example.tripservice.modules.station.application.dto.request.AddStationCommand;
import com.example.tripservice.modules.station.application.dto.request.EditStationCommand;
import com.example.tripservice.modules.station.application.usecase.AddStationUseCase;
import com.example.tripservice.modules.station.application.usecase.EditStationUseCase;
import com.example.tripservice.modules.station.presentation.rest.dto.request.AddStationRequest;
import com.example.tripservice.modules.station.presentation.rest.dto.request.EditStationRequest;
import com.example.tripservice.modules.shared.domain.annotations.SuccessResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.tripservice.modules.station.application.dto.response.GetStationsResult;
import com.example.tripservice.modules.station.application.usecase.GetStationsUseCase;
import com.example.tripservice.modules.station.presentation.rest.dto.response.StationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Getter
public class StationController {

    private final GetStationsUseCase getStationService;
    private final AddStationUseCase addStationService;
    private final EditStationUseCase editStationService;

    @GetMapping("/stations")
    @SuccessResponse(message = "station.get_list")
    public ResponseEntity<List<StationResponse>> getAll() {
        GetStationsResult getStationsResult = getStationService.execute();
        return ResponseEntity.ok(
                getStationsResult.stations()
                        .stream()
                        .map(stationResult -> new StationResponse(
                                stationResult.stationId(),
                                stationResult.stationName(),
                                stationResult.stationCode(),
                                stationResult.cityId(),
                                stationResult.stationAddress(),
                                stationResult.status()
                        ))
                        .toList()
        );
    }

    @PostMapping("station")
    @SuccessResponse(message = "station.created")
    public ResponseEntity<Void> addStation(@RequestBody AddStationRequest request) {
        addStationService.execute(
                new AddStationCommand(
                        request.stationName(),
                        request.stationCode(),
                        request.cityId(),
                        request.stationAddress()
                )
        );

        return ResponseEntity.ok().build();
    }

    @PutMapping("station/{id}")
    @SuccessResponse(message = "station.updated")
    public ResponseEntity<Void> editStation(@PathVariable int id,
                                           @RequestBody EditStationRequest request) {
        editStationService.execute(
          new EditStationCommand(
                  id,
                  request.stationName(),
                  request.stationCode(),
                  request.cityId(),
                  request.stationAddress()
          ));
        return ResponseEntity.ok().build();
    }
}
