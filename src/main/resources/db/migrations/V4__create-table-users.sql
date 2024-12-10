CREATE TABLE users(
    id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    login VARCHAR(40),
    password VARCHAR(40)
)