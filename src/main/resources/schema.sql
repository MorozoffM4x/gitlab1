DROP TABLE IF EXISTS result CASCADE;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 1;
CREATE TABLE result(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    fname        VARCHAR         NOT NULL,
    lname        VARCHAR         NOT NULL,
    date       DATE         NOT NULL,
    event       VARCHAR         NOT NULL,
    distance       INTEGER         NOT NULL,
    time    TIME         NOT NULL
);