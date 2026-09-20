package com.example.tripservice.modules.station.infrastructure.persistence.entity;

import com.example.tripservice.modules.station.domain.valueobjects.StationStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(
        name = "station",
        schema = "trip_service",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_station_name",
                        columnNames = "station_name"
                ),
                @UniqueConstraint(
                        name = "uk_station_code",
                        columnNames = "station_code"
                )
        }
)
@Data
public class StationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "station_name", nullable = false, length = 100)
    private String stationName;

    @Column(name = "station_code", nullable = false, length = 20)
    private String stationCode;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "station_address", nullable = false, length = 200)
    private String stationAddress;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private StationStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}