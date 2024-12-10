package com.app.App_projects.services;

import com.app.App_projects.DTO.ParticipantesDTO;
import com.app.App_projects.domain.participantes.Participantes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface participantesService {

    void updateParticipantes(UUID id, Participantes participantes) throws Exception;

    void deleteParticipante(UUID id);

    Optional<ParticipantesDTO> findById(UUID id);

    Optional<ParticipantesDTO> findByNome(String nome);

    void insertParticipanteDTO(ParticipantesDTO participantesDTO);

    List<ParticipantesDTO> getAllParticipantes();
}
