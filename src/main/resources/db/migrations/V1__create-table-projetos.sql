CREATE TABLE projetos(
    id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    titulo VARCHAR(30) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    tecnologias VARCHAR(100) NOT NULL
)