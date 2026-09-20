package com.example.tripservice.modules.station.infrastructure.persistence.repository;

import com.example.tripservice.modules.station.domain.valueobjects.StationErrorCode;
import com.example.tripservice.modules.station.infrastructure.persistence.entity.StationJpaEntity;
import com.example.tripservice.modules.shared.domain.core.dto.ApiException;
import com.example.tripservice.modules.shared.domain.core.error_code.CommonErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.tripservice.modules.station.domain.entity.Station;
import com.example.tripservice.modules.station.domain.repository.StationRepository;
import com.example.tripservice.modules.station.infrastructure.persistence.mapper.StationPersistenceMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
@RequiredArgsConstructor
public class StationRepositoryAdapter implements StationRepository {

    private final JpaStationRepository stationRepository;

    private final StationPersistenceMapper mapper;

    @Override
    public List<Station> getAll() {
        return stationRepository.getAll()
                .stream()
                .map(
                    mapper::toDomain
                )
                .toList();
    }

    @Override
    public void save(Station station) {
        try {
            stationRepository.save(
                    mapper.fromDomain(
                            station
                    )
            );
        } catch (DataIntegrityViolationException exception) {
            String message = exception.getMostSpecificCause().getMessage();
            if (message.contains("uk_station_name")) {
                throw new ApiException(StationErrorCode.DUPLICATE_STATION_NAME, exception.getMostSpecificCause());
            }
            if (message.contains("uk_station_code")) {
                throw new ApiException(StationErrorCode.DUPLICATE_STATION_CODE, exception.getMostSpecificCause());
            }
            throw new ApiException(CommonErrorCode.DATA_VIOLATION, exception.getMostSpecificCause());
        }
    }

    @Override
    public Station findById(int id) {
         StationJpaEntity jpaEntity = stationRepository.getByStationId(id).orElseThrow();
         return mapper.toDomain(jpaEntity);
    }

    @Override
    public boolean existsById(int id) {
        return stationRepository.existsById(id);
    }

    @Override
    public boolean existsByCodeAndNotId(String code, int id) {
        return stationRepository.existsByStationCodeAndStationIdNot(code, id);
    }

    @Override
    public boolean existsByNameAndNotId(String name, int id) {
        return stationRepository.existsByStationNameAndStationIdNot(name, id);
    }

    @Override
    public boolean existsByCode(String code) {
        return stationRepository.existsByStationCode(code);
    }

    @Override
    public boolean existsByName(String name) {
        return stationRepository.existsByStationName(name);
    }
}
