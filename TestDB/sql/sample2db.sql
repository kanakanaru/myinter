drop database if exists sample2db;
create database sample2db;
use sample2db;

create table sample_table(
No int,
name varchar(50),
age int,
Mail varchar(50));

insert into sample_table values(1,"Yamada",21,"xxx@yagoo.co.jp");
insert into sample_table values(2,"Sato",39,"yyy@google.com");
insert into sample_table values(3,"Harada",44,"zzz@yagoo.co.jp");