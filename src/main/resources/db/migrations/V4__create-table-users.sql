CREATE TABLE users(
    id UUID PRIMARY KEY NOT NULL,
    login VARCHAR(40),
    password VARCHAR(40)
);