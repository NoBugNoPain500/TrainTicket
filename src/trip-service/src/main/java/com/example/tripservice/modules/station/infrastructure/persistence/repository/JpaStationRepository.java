package com.example.tripservice.modules.station.infrastructure.persistence.repository;

import com.example.tripservice.modules.station.infrastructure.persistence.entity.StationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaStationRepository
        extends JpaRepository<StationJpaEntity, Integer> {
    @Query("select n from StationJpaEntity n order by n.stationName asc")
    List<StationJpaEntity> getAll();

    Optional<StationJpaEntity> getByStationId(int id);

    boolean existsByStationId(int id);

    boolean existsByStationNameAndStationIdNot(String code, int id);

    boolean existsByStationCodeAndStationIdNot(String code, int id);

    boolean existsByStationName(String name);

    boolean existsByStationCode(String code);

}
