package com.app.App_projects.DTO;

import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.domain.redes.Redes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantesDTO implements Serializable {
    private UUID id;
    private String nome;
    private String descricao;
    private Long codParticipante;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Projetos> projetosList;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Redes> redesList;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonIgnore // Oculta na serialização (POST e PUT)
    public List<Projetos> getProjetosList() {
        return projetosList;
    }

    public void setProjetosList(List<Projetos> projetosList) {
        this.projetosList = projetosList;
    }

    @JsonIgnore // Oculta na serialização (POST e PUT)
    public List<Redes> getRedesList() {
        return redesList;
    }

    public void setRedesList(List<Redes> redesList) {
        this.redesList = redesList;
    }

    public Long getCodParticipante() {
        return codParticipante;
    }

    public void setCodParticipante(Long codParticipante) {
        this.codParticipante = codParticipante;
    }
}
