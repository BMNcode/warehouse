CREATE TABLE IF NOT EXISTS Public.goods (
  id_product int8 not null,
  name_product varchar(255) not null,
  unit_product varchar(20),
  description varchar(1000),
  PRIMARY KEY (id_product)
) WITHOUT OIDS;

CREATE TABLE IF NOT EXISTS Public.warehouse (
  id_product int8 not null references goods(id_product) on delete cascade,
  date_receipt timestamp not null,
  count_product int8 not null,
  description varchar(1000)
) WITHOUT OIDS;

CREATE TABLE IF NOT EXISTS Public.orders (
  id_order int8 not null,
  id_product int8 not null references goods(id_product) on delete cascade,
  organization varchar(255) not null,
  count_product int8 not null,
  description varchar(1000),
  PRIMARY KEY (id_order)
) WITHOUT OIDS;

CREATE TABLE IF NOT EXISTS Public.release_goods (
  id_order int8 not null references orders(id_order),
  id_product int8 not null references goods(id_product) on delete cascade,
  date_release timestamp not null,
  count_product int8 not null,
  description varchar(1000)
) WITHOUT OIDS;