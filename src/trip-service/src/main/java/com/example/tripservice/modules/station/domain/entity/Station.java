package com.example.tripservice.modules.station.domain.entity;

import com.example.tripservice.modules.station.domain.valueobjects.StationStatus;

public class Station {

    private Integer stationId;

    private String stationName;

    private String stationCode;

    private Integer cityId;

    private String stationAddress;

    private StationStatus status;

    public Station(
            Integer stationId,
            String stationName,
            String stationCode,
            Integer cityId,
            String stationAddress,
            StationStatus status
    ) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.cityId = cityId;
        this.stationAddress = stationAddress;
        this.status = status;
    }

    public Integer getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void changeName(String stationName) {
        this.stationName = stationName;
    }

    public void changeCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public void changeCity(Integer cityId) {
        this.cityId = cityId;
    }

    public void changeAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public void changeStatus(StationStatus status) {
        this.status = status;
    }

    public static Station createStation(
            String name,
            String code,
            Integer cityId,
            String address
    ) {
        return new Station(
                null,
                name,
                code,
                cityId,
                address,
                StationStatus.ACTIVE
        );
    }

    public static Station reconstitute(
            Integer id,
            String name,
            String code,
            Integer cityId,
            String address,
            StationStatus status
    ) {
        return new Station(
                id,
                name,
                code,
                cityId,
                address,
                status
        );
    }
}