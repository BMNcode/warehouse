insert into goods(id_product, name_product, unit_product, description)
values
(1, 'Штукатурка ROTBAND', 'шт', 'поставляются в мешках по 30 кг'),
(2, 'Гипсокартон Knauf', 'м2', 'листы 2.5мх1.2м'),
(3, 'Брус строганый', 'шт', ' 40х40х3000мм');

insert into warehouse(id_product, date_receipt, count_product, description)
values
(1, '2020-01-01 10:10:10', 100, '100 мешков'),
(2, '2020-01-01 10:40:10', 100, '100 листов'),
(3, '2020-01-01 10:40:10', 100, '100 штук');

insert into orders(id_order, id_product, organization, count_product, description)
values
(1, 1, 'ИП "ПЕТРОВ"', 50, '50 мешков'),
(2, 2, 'ИП "ИВАНОВ"', 50, '50 листов'),
(3, 3, 'ИП "БОБРОВ', 50, '100 штук');

insert into release_goods(id_order, id_product, date_release, count_product, description)
values
(1, 1, '2020-01-02 10:10:10', 50, '50 мешков'),
(2, 2, '2020-01-02 10:10:10', 50, '50 листов'),
(3, 3, '2020-01-02 10:10:10', 50, '100 штук');