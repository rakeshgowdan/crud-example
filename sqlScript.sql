create database crud;
drop database crud;
use crud;
drop table employee;
create table emplyoee(employeeId int auto_increment,name varchar(50),address varchar(50),primary key(employeeId));

insert into emplyoee values(101,"A","Bengaluru");
insert into emplyoee values(102,"B","Bengaluru");
insert into emplyoee values(103,"C","Bengaluru");
insert into emplyoee values(104,"D","Bengaluru");

SELECT * FROM crud.emplyoee;