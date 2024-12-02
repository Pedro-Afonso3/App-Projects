CREATE TABLE redes(
    id UUID PRIMARY KEY NOT NULL,
    nome VARCHAR(200) NOT NULL,
    linkRedes VARCHAR(200) NOT NULL,
    participantes_id UUID,
    FOREIGN KEY (participantes_id) REFERENCES Participantes(id)
)