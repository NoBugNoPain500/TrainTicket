package com.example.tripservice.modules.station.infrastructure.persistence.mapper;

import com.example.tripservice.modules.station.domain.entity.Station;
import com.example.tripservice.modules.station.infrastructure.persistence.entity.StationJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StationPersistenceMapper {

    Station toDomain(StationJpaEntity stationJpa);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StationJpaEntity fromDomain(Station station);
}
