create table if not exists trip_service.station(
    station_id int generated always as identity,
    station_name varchar(100) not null,
    station_code varchar(20) not null,
    city_id int not null,
    station_address varchar(20) not null,
    status varchar(20) not null default 'ACTIVE',
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),
    constraint pk_station_id primary key(station_id),
    constraint uk_station_name unique (station_name),
    constraint uk_station_code unique (station_code)
);



