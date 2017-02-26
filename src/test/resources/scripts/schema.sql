CREATE TABLE trader(
  trader_id INT AUTO_INCREMENT CONSTRAINT trader_pkey PRIMARY KEY ,
  trader_name TEXT,
  trader_phone VARCHAR CONSTRAINT phone_lenght CHECK (length(trader_phone) = 11)
);
CREATE TABLE features(
  features_id INT AUTO_INCREMENT CONSTRAINT features_pkey PRIMARY KEY ,
  count_of_room INTEGER,
  condition TEXT,
  repair TEXT
);

CREATE TABLE city(
  city_id INT AUTO_INCREMENT CONSTRAINT city_pkey PRIMARY KEY ,
  city_name TEXT
);

CREATE TABLE street(
  street_id INT AUTO_INCREMENT CONSTRAINT street_pkey PRIMARY KEY ,
  city_id INTEGER,
  street_name TEXT,

  FOREIGN KEY (city_id) REFERENCES city(city_id)
);

CREATE TABLE address(
  id_address INT AUTO_INCREMENT CONSTRAINT address_pkey PRIMARY KEY ,
  city_id INTEGER,
  street_id INTEGER,
  house INTEGER,
  flat INTEGER,

  FOREIGN KEY (city_id) REFERENCES city(city_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (street_id) REFERENCES street(street_id)

);

CREATE TABLE offers(
  id_flat INT AUTO_INCREMENT CONSTRAINT offers_pkey PRIMARY KEY ,
  address_id INTEGER,
  features_id INTEGER,
  trader_id INTEGER,
  cost INTEGER,

  FOREIGN KEY (address_id) REFERENCES address(id_address),
  FOREIGN KEY (features_id) REFERENCES features(features_id),
  FOREIGN KEY (trader_id) REFERENCES trader(trader_id)
);
-- CREATE VIEW fullstreet AS SELECT c.*, s.street_id, s.street_name FROM city as c INNER JOIN street as s ON (c.city_id = s.city_id );
--
-- CREATE VIEW full_addresses AS SELECT a.* FROM address as a INNER JOIN fullstreet as f_a ON (a.street_id = f_a.street_id, a.city_id = f_a.city_id);
--
-- CREATE VIEW full_offers AS
--   SELECT offers.trader_id,
--     offers.features_id,
--     offers.id_flat,
--     offers.address_id,
--     offers.cost,
--     full_addresses.street_id,
--     full_addresses.city_id,
--     full_addresses.house,
--     full_addresses.flat,
--     full_addresses.street_name,
--     full_addresses.city_name,
--     features.count_of_room,
--     features.condition,
--     features.repair,
--     trader.trader_name,
--     trader.trader_phone
--   FROM (offers
--            INNER JOIN full_addresses ON (offers.address_id = full_addresses.id_address)
--           INNER  JOIN features ON (offers.features_id = features.features_id)
--          INNER JOIN trader ON (offers.trader_id = trader.trader_id))
