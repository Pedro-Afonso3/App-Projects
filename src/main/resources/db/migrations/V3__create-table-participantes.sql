CREATE TABLE participantes(
    id UUID PRIMARY KEY NOT NULL,
    nome VARCHAR(70) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    projetos_id UUID,
    redes_id UUID,
    FOREIGN KEY (projetos_id) REFERENCES projetos(id),
    FOREIGN KEY (redes_id) REFERENCES redes(id)
);