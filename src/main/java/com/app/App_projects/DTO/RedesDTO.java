package com.app.App_projects.DTO;

import com.app.App_projects.domain.participantes.Participantes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class RedesDTO implements Serializable {

    private UUID id;
    private Long codRedes;
    private String nome;
    private String linkRedes;


    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParticipantesDTO> participantesList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCodRedes() {
        return codRedes;
    }

    public void setCodRedes(Long codRedes) {
        this.codRedes = codRedes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinkRedes() {
        return linkRedes;
    }

    public void setLinkRedes(String linkRedes) {
        this.linkRedes = linkRedes;
    }

    @JsonIgnore // Oculta na serialização (POST e PUT)
    public Participantes getParticipantesList() {
        return (Participantes) participantesList;
    }

    public void setParticipantesList(List<ParticipantesDTO> participantesList) {
        this.participantesList = participantesList;
    }
}
