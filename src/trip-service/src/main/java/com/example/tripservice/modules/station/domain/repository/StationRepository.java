package com.example.tripservice.modules.station.domain.repository;

import com.example.tripservice.modules.station.domain.entity.Station;

import java.util.List;

public interface StationRepository {

    List<Station> getAll();

    void save(Station station);

    Station findById(int id);

    boolean existsById(int id);

    boolean existsByCodeAndNotId(String code, int id);

    boolean existsByNameAndNotId(String name, int id);

    boolean existsByName(String name);

    boolean existsByCode(String code);
}
