CREATE TABLE bugs (
    bugId    int ,
    deviceId int,
    testerId int
);

CREATE TABLE devices (
    deviceId    int,
    description VARCHAR(25)
);

CREATE TABLE tester_device (
    testerId int,
    deviceId int
);

CREATE TABLE testers (
    testerId  int,
    firstName VARCHAR(25),
    lastName  VARCHAR(25),
    country   VARCHAR(25),
    lastLogin date
);
