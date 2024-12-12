package com.app.App_projects.services;

import com.app.App_projects.DTO.ProjetosDTO;
import com.app.App_projects.domain.projetos.Projetos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface projetoService {

    void insertProjeto(ProjetosDTO projetosDTO);

    void updateProjeto(UUID id, Projetos projetos) throws Exception;

    void deleteProjeto(UUID id);

    List<ProjetosDTO> showAllProjetos();

    Optional<ProjetosDTO> findById(UUID id);

    Optional<ProjetosDTO> findByTitulo(String titulo);

    Optional<ProjetosDTO> buscarPorLinguagem(String tecnologias);
}
