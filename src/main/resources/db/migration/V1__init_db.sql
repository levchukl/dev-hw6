CREATE TABLE IF NOT EXIST worker(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (CHAR_LENGTH(name)<1000 AND CHAR_LENGTH(name)>2),
     birthday DATE  CHECK (birthday>'1901-01-01'),
     level VARCHAR(8) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')) ,
     salary INT CHECK (salary>100 AND salary<100000)
     );

CREATE TABLE IF NOT EXIST client(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (CHAR_LENGTH(name)<1000 AND CHAR_LENGTH(name)>2)
    );

CREATE TABLE IF NOT EXIST project(
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    start_date DATE,
    finish_date DATE
    );

CREATE TABLE IF NOT EXIST project_worker(
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
    );

ALTER TABLE project
ADD CONSTRAINT client_id_fk
FOREIGN KEY(client_id)
REFERENCES client(id);