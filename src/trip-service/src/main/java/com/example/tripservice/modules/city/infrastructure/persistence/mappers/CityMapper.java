package com.example.tripservice.modules.city.infrastructure.persistence.mappers;

import com.example.tripservice.modules.city.domain.entities.City;
import com.example.tripservice.modules.city.infrastructure.persistence.entities.CityJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toDomain(CityJpaEntity cityJpaEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CityJpaEntity fromDomain(City city);
}