package com.example.movieservice.modules.nation.infrastructure.persistence.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.movieservice.modules.nation.domain.entity.Nation;
import com.example.movieservice.modules.nation.domain.repository.NationRepository;
import com.example.movieservice.modules.nation.infrastructure.persistence.mapper.NationPersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter
@RequiredArgsConstructor
public class NationRepositoryAdapter implements NationRepository {

    private final JpaNationRepository nationRepository;

    private final NationPersistenceMapper mapper;

    @Override
    public List<Nation> getAll() {
        return nationRepository.getAllBy()
                .stream()
                .map(
                    mapper::toDomain
                )
                .toList();
    }

    @Override
    public void save(Nation nation) {

    }
}
