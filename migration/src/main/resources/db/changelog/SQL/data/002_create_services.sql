create table employees_services
(
    employee_id bigint,
    id          bigserial not null,
    first_name  varchar(255),
    last_name   varchar(255),
    surname     varchar(255),
    primary key (id)
);
create table positions_services
(
    date_appointment bigint,
    date_dismissal   bigint,
    employee_id      bigint constraint pssfk references employees_services,
    id               bigserial not null,
    position_id      bigint,
    primary key (id)
);