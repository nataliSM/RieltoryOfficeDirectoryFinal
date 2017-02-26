INSERT INTO city(city_name) VALUES
('Казань'),
('Москва'),
('Санкт-Петербург'),
('Бугульма'),
('Волгоград'),
('Нижний Новгород'),
('Сочи');


INSERT INTO street(city_id,street_name) VALUES
 (1,'Завойского'),
 (1,'Адоратского'),
 (2,'Арбат'),
 (3,'Невская'),
 (3,'Думская'),
 (4,'Проспект Ленина'),
 (6,'Академика Павлова'),
 (5,'Звездная'),
 (7,'Айвазовского');

INSERT INTO trader(trader_name,trader_phone) VALUES
 ('Наталья','89477336214'),
 ('Владимир','89477436414'),
 ('Игорь','89637336214'),
 ('Никита','89477321214'),
 ('Ксения','89477336210'),
 ('Чингиз','89277336214'),
 ('Владислав','89577336214');


INSERT INTO address(city_id,street_id,house,flat) VALUES
 (1,1,24,13),
 (1,2,2,98),
 (2,3,13,4),
 (3,4,2,76),
 (3,5,13,189),
 (4,6,3,13),
 (7,9, 3, 44);

INSERT INTO features(count_of_room,condition,repair) VALUES
 (2,'Хорошее','Евро-ремонт'),
 (1,'Удовлетворительное','Косметический'),
 (3,'Хорошее','Косметический'),
 (1,'Хорошее','Черновой'),
 (1,'Плохое','Черновой'),
 (3,'Замечательное','Евро-ремонт'),
 (2,'Удовлетворительное','Косметический');

INSERT INTO offers(address_id, features_id, trader_id, cost) VALUES
 (1,2,3,12000),
 (2,1,2,100000),
 (3,4,1,15000),
 (4,3,5,20000),
 (5,6,4,11000),
 (6,5,7,20000),
 (7,7,6,16000);

-- CREATE OR REPLACE FUNCTION public.trigger_after_del()
--  RETURNS trigger
--  LANGUAGE plpgsql
-- AS $function$
-- BEGIN
--  DELETE FROM address WHERE id_address = old.address_id;
--  DELETE  FROM features WHERE features_id = old.features_id;
--  if ((SELECT COUNT(*) FROM offers WHERE trader_id = old.trader_id)) = 0
-- then DELETE FROM trader WHERE trader_id = old.trader_id;
-- end if;
--
--  RETURN old;
--
-- END;
--  $function$;
--
--
--   CREATE TRIGGER trigger_after_del AFTER DELETE  ON offers FOR EACH ROW
--   EXECUTE PROCEDURE  trigger_after_del();

