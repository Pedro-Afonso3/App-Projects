package com.app.App_projects.services;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.repository.participantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface participantesService {

    void insertParticipantes(Participantes participantes);

    void updateParticipantes(UUID id, Participantes participantes) throws Exception;

    void deleteParticipante(UUID id);

    Iterable<Participantes> showAllParticipantes();

    Optional<Participantes> showById(UUID id);

    Optional<Participantes> findByName(String name);

}
