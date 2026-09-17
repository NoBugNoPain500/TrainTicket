package com.example.movieservice.modules.nation.domain.repository;

import com.example.movieservice.modules.nation.domain.entity.Nation;

import java.util.List;

public interface NationRepository {

    List<Nation> getAll();

    void save(Nation nation);

    Nation findById(int id);
}
