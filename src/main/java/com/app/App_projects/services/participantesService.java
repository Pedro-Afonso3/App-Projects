package com.app.App_projects.services;

import com.app.App_projects.domain.participantes.Participantes;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


public interface participantesService {

    void insertParticipantes(Participantes participantes);

    void updateParticipantes(UUID id, Participantes participantes) throws Exception;

    void deleteParticipante(UUID id);

    Iterable<Participantes> showAllParticipantes();

    Optional<Participantes> showById(UUID id);

    Optional<Participantes> findByNome(String nome);

}
