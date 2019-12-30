drop table if exists cricketers;
create table cricketers(
    id int not null auto_increment,
    skill varchar(20) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    primary key(id)
);