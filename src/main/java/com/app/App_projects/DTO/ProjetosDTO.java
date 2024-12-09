package com.app.App_projects.DTO;

import com.app.App_projects.domain.participantes.Participantes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class ProjetosDTO implements Serializable {
    private String id;
    private String titulo;
    private String descicao;
    private String tecnologias;
    private Long codProjeto;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParticipantesDTO> participantesList;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getCodProjeto() {
        return codProjeto;
    }

    public void setCodProjeto(Long codProjeto) {
        this.codProjeto = codProjeto;
    }
}
