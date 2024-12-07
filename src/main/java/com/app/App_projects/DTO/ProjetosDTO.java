package com.app.App_projects.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

public class ProjetosDTO implements Serializable {
    private String titulo;
    private String descicao;
    private String tecnologias;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParticipantesDTO> participantesDTOList;

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

    public List<ParticipantesDTO> getParticipantesDTOList() {
        return participantesDTOList;
    }

    public void setParticipantesDTOList(List<ParticipantesDTO> participantesDTOList) {
        this.participantesDTOList = participantesDTOList;
    }
}
