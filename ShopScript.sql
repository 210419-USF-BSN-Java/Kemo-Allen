drop table customers cascade;
drop table employees cascade;
drop table managers cascade;
drop table items cascade;
drop table inventories cascade;
drop table offers cascade;
drop table offer_histories cascade;
drop table payments cascade;

create table customers(
	user_id serial primary key,
	user_name varchar(30) unique,
	pass_word varchar(30) not null,
	is_logged_in boolean default false

);

create table managers(
	user_id serial primary key,
	user_name varchar(30) unique,
	pass_word varchar(30) not null,
	is_logged_in boolean default false

);

create table employees(
	user_id serial primary key,
	user_name varchar(30) unique,
	pass_word varchar(30) not null,
	manager_id int references managers(user_id),
	-- position varchar(30),
	is_logged_in boolean default false

);

create table items(
	item_id serial primary key,
	item_name varchar(30) unique,
	description varchar(30),
	price float8 not null,
	is_owned boolean default false

);

--Java code
create table inventories(
	inventory_id serial primary key,
	customer_id int references customers(user_id),
	item_name varchar(30) not null,
	description varchar(30)

);

create table offers(
	offer_id serial primary key,
	customer_id int references customers(user_id),
	item_id int references items(item_id),
	item_price float8 not null,
	payment_type varchar(30),
	is_accepted boolean default false
	
);

create table offer_histories(
	history_id serial primary key,
	--offer_id int references offers(offer_id),
	customer_id int references customers(user_id),
	item_id int references items(item_id),
	payment_type varchar(30),
	status varchar(30) not null

);

create table payments(
	payment_id serial primary key,
	customer_id int references customers(user_id),
	item_id int references items(item_id),
	--NUMERIC(6,2) 9999.99
	item_price float8 not null,
	rate float8,
	number_of_payments int not null,
	payments_remaining int not null

);

select * from customers;
select * from employees;
select * from managers;
select * from items;
select * from offers;
select * from payments;
select * from inventories;
select * from offer_histories;
insert into employees (user_name, pass_word, manager_id) values('Kemo', '123', 1);
insert into managers (user_name, pass_word) values('Kevin', '123');
insert into items (item_name, description, price) values('Icebrand', 'Icy Sword', 199.19);
select * from offers;
delete from offers where offer_id = 2;
delete from employees where user_id = 2;
