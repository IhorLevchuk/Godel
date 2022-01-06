INSERT INTO category VALUES
(1, 'Studies'),
(2, 'Accommodation'),
(3, 'Presents'),
(4, 'Children'),
(5, 'Transport'),
(6, 'Startup');


INSERT INTO expense (name, created_at, category, amount) VALUES
('Coffee', '2021-08-21', null, 1.2),
('Headphones', '2021-07-18', null, 106.7),
('Books', '2021-08-21', 1, 14.5),
('Notebooks', '2021-08-14', 1, 30.1),
('Rent', '2021-07-1', 2, 400.0),
('Rent', '2021-08-1', 2, 400.0),
('Rent', '2021-09-1', 2, 400.0),
('Cloth', '2021-08-21', 4, 324.8),
('Hospital', '2021-09-14', 4, 80.0),
('Travel card', '2021-07-18', 5, 42.38),
('Travel card', '2021-08-27', 5, 42.38);