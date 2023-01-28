CREATE TYPE role_enum AS ENUM ('USER','ADMIN');
CREATE CAST (VARCHAR AS role_enum) WITH INOUT AS IMPLICIT;

CREATE TABLE users
(
    id        int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,
    email     TEXT,
    username  TEXT,
    password  TEXT,
    role      role_enum
)