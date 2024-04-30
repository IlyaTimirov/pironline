create table companies
(
    inn  integer,
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);
create table positions
(
    salary           float(53),
    id               bigserial not null,
    name             varchar(255),
    primary key (id)
);
create table employees
(
    company_id    bigint not null constraint cmpfk references companies,
    date_of_birth bigint,
    id            bigserial not null,
    position_id   bigint unique constraint psfk references positions,
    first_name   varchar(255),
    last_name   varchar(255),
    surname   varchar(255),
    sex           varchar(255),
    snils         varchar(255),
    date_appointment bigint,
    date_dismissal   bigint,
    primary key (id)
);
