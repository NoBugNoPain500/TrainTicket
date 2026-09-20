package com.example.tripservice.modules.city.infrastructure.persistence.repositories;

import com.example.tripservice.modules.city.infrastructure.persistence.entities.CityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Integer> {
    @Query("select c from CityJpaEntity c " +
            "order by c.cityId asc")
    List<CityJpaEntity> getAll();

    boolean existsByCityName(String cityName);
}
