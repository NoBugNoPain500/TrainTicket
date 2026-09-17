package com.example.movieservice.modules.nation.infrastructure.persistence.repository;

import com.example.movieservice.modules.nation.infrastructure.persistence.entity.NationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaNationRepository
        extends JpaRepository<NationJpaEntity, Integer> {
    List<NationJpaEntity> getAllBy();

    Optional<NationJpaEntity> getByNationId(int id);
}
