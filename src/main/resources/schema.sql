drop table if exists employee CASCADE;
drop table if exists project CASCADE;
drop table if exists project_employee CASCADE;
create table employee
(
    employee_id bigint generated by default as identity,
    email       varchar(255),
    first_name  varchar(255),
    last_name   varchar(255),
    primary key (employee_id)
);
create table project
(
    project_id  bigint generated by default as identity,
    description varchar(255),
    name        varchar(255),
    stage       varchar(255),
    primary key (project_id)
);
create table project_employee
(
    project_id  bigint not null,
    employee_id bigint not null
);
alter table project_employee
    add constraint FKn5yqs0xm3rmsg62n84ccyk4k0 foreign key (employee_id) references employee;
alter table project_employee
    add constraint FK1907nkisp2dlsswuycpnakiv8 foreign key (project_id) references project;