DROP TABLE planet IF EXISTS;
create table planet 
(
   id long not null AUTO_INCREMENT,
   name varchar(255) not null,
   climate varchar(255) not null,
   terrain varchar(255) not null,
   films integer,
   primary key(id)
);