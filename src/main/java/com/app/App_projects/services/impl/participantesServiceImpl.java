package com.app.App_projects.services.impl;

import com.app.App_projects.DTO.ParticipantesDTO;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.repository.participantesRepository;
import com.app.App_projects.services.participantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class participantesServiceImpl implements participantesService {

    @Autowired
    private participantesRepository repository;

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

    // Converte Participantes para ParticipantesDTO
    private ParticipantesDTO convertToDTO(Participantes participantes) {
        ParticipantesDTO participantesDTO = new ParticipantesDTO();
        participantesDTO.setNome(participantes.getNome());
        participantesDTO.setDescricao(participantes.getDescricao());
        participantesDTO.setRedesList(participantes.getRedesList());
        participantesDTO.setProjetosList(participantes.getProjetosList());
        return participantesDTO;
    }

    // Converte ParticipantesDTO para Participantes
    private Participantes convertToEntity(ParticipantesDTO participantesDTO) {
        Participantes participantes = new Participantes();
        participantes.setNome(participantesDTO.getNome());
        participantes.setDescricao(participantesDTO.getDescricao());
        participantes.setRedesList(participantesDTO.getRedesList());
        participantes.setProjetosList(participantesDTO.getProjetosList());
        return participantes;
    }

    //CADASTRAR PARTICIPANTE
    @Override
    public void insertParticipanteDTO(ParticipantesDTO participantesDTO) {
        // Converte o DTO para a entidade Participantes antes de salvar
        Participantes participantes = convertToEntity(participantesDTO);
        repository.save(participantes);
    }

    //BUSCAR POR TODOS
    @Override
    public List<ParticipantesDTO> getAllParticipantes() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    //BUSCAR POR NOME
    @Override
    public  Optional<ParticipantesDTO> findByNome(String nome) {
        return repository.findByNome(nome)
                .map(this::convertToDTO);
    }

    //BUSCAR POR ID
    @Override
    public  Optional<ParticipantesDTO> findById(UUID id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    // Converte lista de Participantes para lista de ParticipantesDTO
    private Iterable<ParticipantesDTO> convertToDTOList(Iterable<Participantes> participantesList) {
        List<ParticipantesDTO> participantesDTOList = new ArrayList<>();
        for (Participantes participantes : participantesList) {
            participantesDTOList.add(convertToDTO(participantes));
        }
        return participantesDTOList;
    }
}
