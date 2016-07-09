-- creating database
drop database if exists GWDB;
create database if not exists GWDB;

use GWDB;

-- dropping previous users (if they existed)
drop user if exists 'dba'@'%';
drop user if exists 'load_data'@'%';
drop user if exists 'user_access'@'%';
drop user if exists 'system'@'%';
drop user if exists 'service_user'@'%';

-- [re]creating users
create user 'dba'@'%' identified by '-X#,g?;hC-cDs;*N2JGm'; -- example password (TODO: change in production)
create user 'load_data'@'%' identified by 'Src+J$xNP4#(S5Bm_K#`'; -- example password (TODO: change in production)
create user 'user_access'@'%' identified by '4L^-rr7)X369Vj]L9D<7'; -- example password (TODO: change in production)
create user 'system'@'%' identified by 'C(+2xc(KYPm7+C.qSF#y'; -- example password (TODO: change in production)
create user 'service_user'@'%' identified by '$Me_!ZK<ky>"7/Su/fS-'; -- example password (TODO: change in production)

-- granting priveleges to users
grant all privileges on gwdb.* to 'system'@'%';

use gwdb;
-- creating necessary tables for versioning
drop table if exists SYS_VERSIONS;
create table SYS_VERSIONS (
    ID int primary key auto_increment,
    VERSION varchar(15) not null,
    DATE_INSTALLED datetime not null,
    MESSAGE varchar(500)
);

drop table if exists SYS_INSTALLATIONS;
create table SYS_INSTALLATIONS (
    ID int primary key auto_increment,
    VERSION varchar(15) not null,
    INSTALLATION_TYPE varchar(50) not null,
    RUN_DATE datetime not null,
    RUN_SQL varchar(500),
    MESSAGE varchar(500)
);

drop table if exists M_TABLES;
create table M_TABLES (
    ID int primary key auto_increment,
    TABLE_NAME varchar(30) not null,
    ACRONYM varchar(8) not null,
    DATE_CREATED datetime default current_timestamp
);

drop table if exists M_COLUMNS;
create table M_COLUMNS (
    ID int primary key auto_increment,
    TABLE_ID int,
    COLUMN_NAME varchar(30) not null,
    DATE_CREATED datetime default current_timestamp,
    
    foreign key (TABLE_ID)
    references M_TABLES (ID)
    on update cascade on delete restrict
);