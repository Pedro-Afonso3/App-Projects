CREATE TABLE projetos(
    id UUID PRIMARY KEY NOT NULL,
    titulo VARCHAR(30) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    tecnologias VARCHAR(100) NOT NULL,
    participantes_id UUID,
    FOREIGN KEY (participantes_id) REFERENCES Participantes(id)
)