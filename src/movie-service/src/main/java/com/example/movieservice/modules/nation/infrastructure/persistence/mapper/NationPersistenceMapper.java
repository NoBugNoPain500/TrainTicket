package com.example.movieservice.modules.nation.infrastructure.persistence.mapper;

import com.example.movieservice.modules.nation.domain.entity.Nation;
import com.example.movieservice.modules.nation.infrastructure.persistence.entity.NationJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NationPersistenceMapper {

    Nation toDomain(NationJpaEntity nationJpa);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    NationJpaEntity fromDomain(Nation nation);
}
