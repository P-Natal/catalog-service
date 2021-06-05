create table type
(
    id              bigserial constraint firstkey primary key,
    name            varchar(50) not null,
    registry_date   timestamp not null,
);

create table product
(
    id              bigserial constraint firstkey primary key,
    code            varchar(20) not null,
    name            varchar(50) not null,
    type            bigint not null references type (id),
    price           int NOT NULL,
    active          boolean not null,
    registry_date   timestamp not null,
    last_update     timestamp not null
);