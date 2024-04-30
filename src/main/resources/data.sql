INSERT INTO brand (id, name) values
(1, 'ZARA');

INSERT INTO price_list (id, name) values
(1, 'Demo price list');

INSERT INTO price (id, brand_id, start_date, end_date, price_list_id, priority, amount, currency_iso_code) values
(0, 1,'2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 0, 35.50, 'EUR');

INSERT INTO product (id, price_id, name) values
(35455, 0,'Demo item');



