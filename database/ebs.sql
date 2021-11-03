CREATE DATABASE EBS;

create table login_a(username varchar(20), password varchar(20));
create table login_c(meter_no varchar(20), username varchar(30), name varchar(30), password varchar(30), user varchar(30));


create table customer(name varchar(30), meter_number varchar(20), address varchar(50), district varchar(50), postcode varchar(30), email varchar(30), phone varchar(20));

create table meter_info(meter_number varchar(20), meter_location varchar(20), meter_type varchar(20), phase_code varchar(20), bill_type varchar(20), days varchar(20));

create table tax_a(meter_location varchar(10), meter_type varchar(15), phase_code varchar(5), bill_type varchar(10), days varchar(5), meter_rent varchar(5), mcb_rent varchar(5), service_rent varchar(5), vat varchar(5));
create table tax_c(cost_per_unit INT, meter_rent INT, service_charge INT , minimum_charge INT, demand_charge INT, vat INT);

create table bill_a(meter_number varchar(10),month varchar(20), units varchar(5), amount varchar(15));

create table bill_c(meter_number varchar(20), month varchar(20), units varchar(20), total_bill INT, status varchar(20));

create table emp(name varchar(20), meter_number varchar(10), address varchar(40), district varchar(20), postcode varchar(15), email varchar(30), phone varchar(15));





insert into tax_c values(5.37,0,0,0,90,80);

INSERT INTO customer VALUES("Sujon", "57438", "Banik Bhavan, Jamal khan by lane,Chattogram", "Chattogram", "Chattogram - 4000","sc@duuck.com","01xxxxxxxxx");

insert into bill values("57438", "September", "104","520");
SHOW TABLES FROM EBS;

DROP DATABASE project3;

ALTER TABLE login
ADD user varchar(20);

SELECT * FROM login_c;
SELECT * FROM login_a;
SELECT * FROM customer;
SELECT * FROM meter_info;
SELECT * FROM tax_a;
SELECT * FROM tax_c;
SELECT * FROM bill_a;
SELECT * FROM bill_c;
SELECT * FROM emp;

DROP TABLE tax1;
DROP TABLE tax_c;
DROP TABLE bill_c;
DROP TABLE customer;
DROP TABLE emp;
DROP TABLE login;
DROP TABLE meter_info;


DELETE FROM customer; 
DELETE FROM login_c WHERE  meter_no = '197116';