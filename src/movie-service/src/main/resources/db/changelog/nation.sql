create schema if not exists movie_service;

create table movie_service.nation(
    nation_id int generated always as identity primary key,
    nation_name varchar(100) unique,
    nation_code varchar(20) unique,
    created_at timestamptz default now(),
    updated_at timestamptz default now()
)