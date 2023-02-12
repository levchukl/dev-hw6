INSERT INTO worker(name, birthday, level, salary)
VALUES
    ('Maks Roy', '1990-02-25', 'Senior', 7500),
    ('Nik Korn', '2002-05-19', 'Junior', 2100),
    ('Luk Dan', '1999-12-08', 'Middle', 4800),
    ('Jon Lenon', '2007-09-09', 'Trainee', 1500),
    ('Eva Van', '2004-04-17', 'Junior', 1800),
    ('Ivan Dorn', '2004-08-06', 'Junior', 1500),
    ('Viki Lyer', '2006-10-08', 'Trainee', 1200),
    ('Kris Null', '1987-05-23', 'Senior', 8000),
    ('Ira Zyh', '2007-11-05', 'Junior', 3500),
    ('Stas Soha', '2010-07-19', 'Middle', 5500);

INSERT INTO client (name)
VALUES
    ('Bob Ranj'),
    ('Gim Malkin'),
    ('Federik Kroy'),
    ('Daniel Bill'),
    ('Bred Joker');

INSERT INTO project (client_id, start_date, finish_date)
VALUES
    (1, '2023-01-13', '2023-12-13'),
    (2, '2022-07-15', '2022-11-30'),
    (1, '2022-05-23', '2024-05-23'),
    (3, '2022-12-01', '2023-12-01'),
    (4, '2023-01-05', '2024-09-15'),
    (5, '2021-05-06', '2023-01-25'),
    (5, '2023-02-12', '2023-09-12'),
    (1, '2023-05-15', '2023-12-01'),
    (4, '2022-09-06', '2023-06-15'),
    (1, '2022-11-24', '2023-03-28');

INSERT INTO project_worker (project_id, worker_id)
VALUES
    (1,3),
    (1,5),
    (1,4),
    (2,10),
    (2,1),
    (3,2),
    (4,6),
    (5,7),
    (5,9),
    (4,8),
    (3,3);
