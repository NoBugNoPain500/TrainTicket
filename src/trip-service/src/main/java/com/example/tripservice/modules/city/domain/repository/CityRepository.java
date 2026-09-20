package com.example.tripservice.modules.city.domain.repository;


import com.example.tripservice.modules.city.domain.entities.City;

import java.util.List;

public interface CityRepository {
    List<City> getAll();
    boolean existsByCityName(String cityName);
}
