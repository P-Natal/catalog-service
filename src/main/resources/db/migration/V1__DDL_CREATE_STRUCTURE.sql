create table type
(
    id              bigserial constraint type_key primary key,
    name            varchar(50) not null,
    registry_date   timestamp not null default current_timestamp
);

create table product
(
    id              bigserial constraint product_key primary key,
    code            varchar(20) not null,
    name            varchar(50) not null,
    type_id         bigint not null references type (id),
    price           float NOT NULL,
    available       boolean not null,
    registry_date   timestamp not null,
    last_update     timestamp not null
);