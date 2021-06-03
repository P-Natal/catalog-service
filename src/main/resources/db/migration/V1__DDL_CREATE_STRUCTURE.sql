create table type
(
    id              bigserial not null primary key,
    name            varchar(50) not null,
    registry_date   timestamp default current_timestamp
);

create table product
(
    id              bigserial not null primary key,
    name            varchar(50) not null,
    type            bigint not null references type (id),
    price           int NOT NULL,
    active          boolean not null,
    registry_date   timestamp default current_timestamp
);