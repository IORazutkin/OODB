create type house as (
    house_id integer,
    address text
);

create type apartment as (
    apartment_id integer,
    apartment_house house,
    apartment_number integer
);

create type person as (
    person_id integer,
    full_name text,
    birth_day date,
    person_apartment apartment
);

create table lab5Person (
    person person
);