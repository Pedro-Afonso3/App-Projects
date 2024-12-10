CREATE TABLE redes(
    id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    nome VARCHAR(200) NOT NULL,
    linkRedes VARCHAR(200) NOT NULL
)