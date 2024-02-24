create database inventory;

use inventory;

create table customers(cid int not null primary key auto_increment, customercode varchar(100) not null, fullname varchar(50) not null, location varchar(50) not null, phone varchar(50) not null, userid int not null);

create table products (pid int not null primary key auto_increment, productcode varchar(100) not null, costprice double not null, sellingprice double not null, brand varchar(50) not null, category varchar(30) not null,userid int not null);

create table purchaseinfo(purchaseid int not null primary key auto_increment, supplierid varchar(200) not null, productcode varchar(200) not null, date varchar(200) not null, quantity float not null, totalcost float not null, productcategory varchar (30) not null, suppliercode varchar(30) not null,userid int not null);

create table salesreport(salesid int not null primary key auto_increment, date varchar(40) not null, productcode varchar(200) not null, customercode varchar(200) not null, quantity int not null, revenue double not null, productcategory varchar(30) not null, customerid int not null,userid int not null);

create table stocks(productid int not null, productcode varchar(100) not null, quantity int not null, userid int not null);

create table suppliers(sid int not null primary key auto_increment, suppliercode varchar(100) not null, fullname varchar(50) not null, location varchar(50) not null, phone varchar(10) not null, userid int not null);

create table users(id int not null primary key auto_increment, fullname varchar(50) not null, location varchar(50) not null, phone varchar(10) not null, username varchar(20) not null, password varchar(200) not null, category varchar(20) not null, shop_no int not null,email varchar(40) not null default "abc@xyz", center varchar(30) not null);

alter table customers auto_increment = 105;

alter table products auto_increment = 1;

alter table purchaseinfo auto_increment = 1;

alter table salesreport auto_increment = 1;

alter table suppliers auto_increment = 1001; 

alter table users auto_increment = 100;

INSERT INTO `pbl_inventory`.`users` (`fullname`, `location`, `phone`, `username`, `password`, `category`, `shop_no`, `email`, `center`) VALUES ('Admin_name', 'Mumbai', '1234567890', 'Admin', '12345', 'Administrator', '0','xyz@gmail.com', 'Mumbai');
