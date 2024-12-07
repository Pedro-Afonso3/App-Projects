package com.app.App_projects.DTO;

import com.app.App_projects.domain.participantes.Participantes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

public class ProjetosDTO implements Serializable {
    private String titulo;
    private String descicao;
    private String tecnologias;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParticipantesDTO> participantesList;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    @JsonIgnore // Oculta na serialização (POST e PUT)
    public Participantes getParticipantesList() {
        return (Participantes) participantesList;
    }

    public void setParticipantesList(List<ParticipantesDTO> participantesList) {
        this.participantesList = participantesList;
    }
}
