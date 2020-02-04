START TRANSACTION;

CREATE TYPE cargo_type_enum as enum ('food', 'clothes');
create type vehicle_type_enum as enum ('plane', 'car', 'train', 'ship');

create table carrier
(
  id           integer           not null primary key,
  name         varchar(255)      not null,
  address      varchar(255)      not null,
  vehicle_type vehicle_type_enum not null
);

create table cargo
(
  id     integer          not null primary key,
  name   varchar(255)     not null,
  weight double precision not null,
  type   cargo_type_enum  not null
);

create table food_cargo_info
(
  id                integer not null primary key,
  id_cargo          integer not null references cargo (id) on delete cascade on update cascade,
  expiration_date   date,
  store_temperature integer
);

create table clothes_cargo_info
(
  id       integer not null primary key,
  id_cargo integer not null references cargo (id) on delete cascade on update cascade,
  size     varchar(255),
  material varchar(255)
);



create table transportation
(
  id                        integer      not null primary key,
  id_cargo                  integer      not null references cargo (id) on delete cascade on update cascade,
  id_carrier                integer      not null references carrier (id) on delete cascade on update cascade,
  description               varchar(255),
  bill_to                   varchar(255) not null,
  transportation_begin_date date         not null
);

COMMIT;
