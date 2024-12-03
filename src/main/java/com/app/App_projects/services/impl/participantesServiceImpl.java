package com.app.App_projects.services.impl;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.repository.participantesRepository;
import com.app.App_projects.services.participantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class participantesServiceImpl implements participantesService {

    @Autowired
    private participantesRepository repository;


    @Override
    public void insertParticipantes(Participantes participantes) {
        repository.save(participantes);
    }

    @Override public void updateParticipantes(UUID id, Participantes participantes) throws Exception {
        Optional<Participantes> participantes1 = repository.findById(id);

        if (participantes1.isPresent()) {
            Participantes participantesExists = participantes1.get();

            if (participantes.getNome() != null) {
                participantesExists.setNome(participantes.getNome());
            }

            if(participantes.getDescricao() != null){
                participantesExists.setDescricao(participantes.getDescricao());
            }

            // Atualizar redesList
            if (participantes.getRedesList() != null) {
            participantesExists.getRedesList().clear();
            participantesExists.getRedesList().addAll(participantes.getRedesList());
            }

            // Atualizar projetosList
            if (participantes.getProjetosList() != null) {
            participantesExists.getProjetosList().clear();
            participantesExists.getProjetosList().addAll(participantes.getProjetosList());
            }

            repository.save(participantesExists);

            }else {

            throw new Exception("Participante não encontrado");
        }
    }

    @Override
    public void deleteParticipante(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Participantes> showAllParticipantes() {
        return repository.findAll();
    }

    @Override
    public  Optional<Participantes>  showById(UUID id) {
        Optional<Participantes> resultShowId = repository.findById(id);
        return  resultShowId;
    }

    @Override
    public  Optional<Participantes> findByNome(String nome) {
        Optional<Participantes> resultShowName = repository.findByNome(nome);
        return resultShowName;

    }
}
