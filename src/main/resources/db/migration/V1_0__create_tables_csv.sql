CREATE TABLE bugs (
    bug_id    int ,
    device_id int,
    tester_id int
);

CREATE TABLE devices (
    device_id    int,
    description VARCHAR(25)
);

CREATE TABLE tester_device (
    tester_id int,
    device_id int
);

CREATE TABLE testers (
    tester_id  int,
    first_name VARCHAR(25),
    last_name  VARCHAR(25),
    country   VARCHAR(25),
    last_login date
);
