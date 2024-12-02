package com.app.App_projects.services.impl;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.repository.projetosRepository;
import com.app.App_projects.services.projetoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class projetoServicesImpl implements projetoService {

    @Autowired
    private projetosRepository repository;

    @Override
    public void insertProjeto(Projetos projetos) {
        repository.save(projetos);
    }

    @Override
    public void updateProjeto(UUID id, Projetos projetos) throws Exception {
        Optional<Projetos> projetos1 = repository.findById(id);

        if (projetos1.isPresent()) {
            Projetos projetosExists = projetos1.get();

            if (projetos.getTitulo() != null) {
                projetosExists.setTitulo(projetos.getTitulo());
            }

            if (projetos.getDescricao() != null) {
                projetosExists.setDescricao(projetos.getDescricao());
            }

            if (projetos.getTecnologias() != null) {
                projetosExists.setTecnologias(projetos.getTecnologias());
            }

            repository.save(projetosExists);
        } else {

            throw new Exception("Projeto não encontrado");
        }
    }

    @Override
    public void deleteProjeto(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Projetos> showAllProjetos() {
        List<Projetos> resultShowAll = repository.findAll();
        return resultShowAll;
    }

    @Override
    public Optional<Projetos> showById(UUID id) {
        Optional<Projetos> resultShowId = repository.findById(id);
        return  resultShowId;
    }

    @Override
    public Optional<Projetos> findByTitulo(String titulo) {
        Optional<Projetos> resultShowTitulo = repository.findByName(titulo);
        return resultShowTitulo;
    }
}
