package com.app.App_projects.controller;

import com.app.App_projects.DTO.ParticipantesDTO;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.services.participantesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participantes")
@Tag(name = "Participantes", description ="Controller para Participantes")
public class participantesController {

    @Autowired
    private participantesService participantesService;

    //CADASTRO DO PARTICIPANTE
    @PostMapping("/insert")
    @Operation(summary = "Cadastrar Participantes", description = "Cadastrar um novo participante")
    public ResponseEntity<ParticipantesDTO> insertParticipanteDTO(@RequestBody ParticipantesDTO participantesDTO){
        participantesService.insertParticipanteDTO(participantesDTO);
        return ResponseEntity.ok(participantesDTO);
    }

    //BUSCA POR TODOS
    @Operation(summary = "Consultar todos", description = "Consultar todos participantes")
    @GetMapping("/showAll")
    public ResponseEntity<Iterable<ParticipantesDTO>> getAllParticipantes(){
        return ResponseEntity.ok(participantesService.getAllParticipantes());
    }

    //BUSCAR POR NOME
    @Operation(summary = "Consultar participantes por nome", description = "Consultar participantes por nome")
    @GetMapping("/findByNome")
    public ResponseEntity<Optional<ParticipantesDTO>> findByNome(String nome){
        return ResponseEntity.ok(participantesService.findByNome(nome));
    }

    //BUSCAR POR ID
    @Operation(summary = "Consultar participantes por ID", description = "Consultar participantes por ID")
    @GetMapping("/findById")
    public ResponseEntity<Optional<ParticipantesDTO>> findById(UUID id){
        return ResponseEntity.ok(participantesService.findById(id));
    }

    //ATUALIZAR POR ID
    @Operation(summary = "Atualizar participantes", description = "Atualizar participantes por ID")
    @PutMapping("/updateParticipantes")
    public ResponseEntity<Participantes> updateParticipantes(UUID id,@RequestBody Participantes participantes) throws Exception {
        participantesService.updateParticipantes(id,participantes);
        return ResponseEntity.ok(participantes);
    }

    //DELETAR POR ID
    @Operation(summary = "Deletar participantes", description = "Deletar participantes por ID")
    @DeleteMapping("/deleteParticipantes")
    public ResponseEntity<Participantes> deleteParticipantes(UUID id){
        participantesService.deleteParticipante(id);
        return ResponseEntity.ok().build();
    }


}
