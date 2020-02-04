START TRANSACTION;


insert into carrier (id, "name", address, vehicle_type)
values (1, 'Open line', 'Russia, Spb, Nevskiy 19', 'car'),
       (2, 'Super Delivery', 'USA', 'AmiracanStreet 24', 'plane'),
       (3, 'Mega-Deliv', 'UK', 'WhiteStreet 12', 'ship');


insert into cargo (id, "name", weight, "type")
values (1, 'Item1', 3.4, 'clothes'),
       (2, 'Item228', 4, 'food'),
       (3, 'Object3', 2.5, 'clothes');


insert into clothes_cargo_info (id, id_cargo, size, material)
values (1, 1, 'oversize', 'cotton'),
       (2, 3, 'medium', 'cotton');

insert into food_cargo_info (id, id_cargo, expiration_date, store_temperature)
values (3, 2, '22-02-2020', 20);


insert into transportation (id, id_cargo, id_carrier, description, bill_to, transportation_begin_date)
values (1, 1, 1, 'bla-bla', 'Andrey', '22-02-2020'),
       (2, 2, 2, 'bla-bla', 'Kirill', '22-02-2020'),
       (3, 3, 3, 'bla-bla-bla', 'Dima', '22-02-2020');

COMMIT;

