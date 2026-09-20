create schema if not exists trip_service;

create table trip_service.city(
    city_id int generated always as identity,
    city_name varchar(200) not null,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),
    constraint pk_city_id primary key (city_id),
    constraint uk_city_name unique (city_name)
)