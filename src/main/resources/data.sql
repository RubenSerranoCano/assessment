INSERT INTO brand (id, name) values
(1, 'ZARA');

INSERT INTO product (id, name) values
(35455, 'Demo item');

INSERT INTO price_list (id, name) values
(1, 'Price list 1'),
(2, 'Price list 2'),
(3, 'Price list 3'),
(4, 'Price list 4');

INSERT INTO price (id, brand_id, start_date_time, end_date_time, price_list_id, product_id, priority, amount, currency_iso_code) values
(0, 1,'2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(1, 1,'2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(2, 1,'2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(3, 1,'2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');

