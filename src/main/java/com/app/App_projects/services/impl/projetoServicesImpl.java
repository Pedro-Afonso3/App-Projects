package com.app.App_projects.services.impl;

import com.app.App_projects.DTO.ParticipantesDTO;
import com.app.App_projects.DTO.ProjetosDTO;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.repository.projetosRepository;
import com.app.App_projects.services.projetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class projetoServicesImpl implements projetoService {

    @Autowired
    private projetosRepository repository;

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


    //Converte Projetos para ProjetosDTO
    private ProjetosDTO convertToDTO(Projetos projetos){
        ProjetosDTO projetosDTO = new ProjetosDTO();
        projetosDTO.setId(projetos.getId());
        projetosDTO.setTitulo(projetos.getTitulo());
        projetosDTO.setDescicao(projetos.getDescricao());
        projetosDTO.setTecnologias(projetos.getTecnologias());
        projetosDTO.setParticipantesList((List<ParticipantesDTO>) projetos.getParticipantes());
        return projetosDTO;
    }

    //Converte ProjetosDTO para Projetos
    private Projetos convertToEntity(ProjetosDTO projetosDTO){
        Projetos projetos = new Projetos();
        projetos.setId(projetosDTO.getId());
        projetos.setTitulo(projetosDTO.getTitulo());
        projetos.setDescricao(projetosDTO.getDescicao());
        projetos.setTecnologias(projetosDTO.getTecnologias());
        projetos.setParticipantes(projetosDTO.getParticipantesList());
        return projetos;
    }

    //CADASTRAR PROJETO
    @Override
    public void insertProjeto(ProjetosDTO projetosDTO) {
        Projetos projetos = convertToEntity(projetosDTO);
        repository.save(projetos);
    }

    //BUSCAR POR TODOS
    @Override
    public List<ProjetosDTO> showAllProjetos() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    //BUSCAR POR ID
    @Override
    public Optional<ProjetosDTO> findById(UUID id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    //BUSCAR POR TITULO
    @Override
    public Optional<ProjetosDTO> findByTitulo(String titulo) {
        return  repository.findByTitulo(titulo)
                .map(this::convertToDTO);
    }

    @Override
    public Optional<ProjetosDTO> buscarPorLinguagem(String tecnologias) {
        return repository.findByTecnologias(tecnologias)
                .map(this::convertToDTO);
    }

}
