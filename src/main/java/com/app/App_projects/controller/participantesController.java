package com.app.App_projects.controller;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.services.participantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participantes")
public class participantesController {

    @Autowired
    participantesService participantesService;

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<Participantes>> showAllParticipantes(){
        return ResponseEntity.ok(participantesService.showAllParticipantes());
    }

    @GetMapping("/showById")
    public ResponseEntity<Optional<Participantes>> showById(@PathVariable UUID id){
        return ResponseEntity.ok(participantesService.showById(id));
    }

    @GetMapping("/findByNome")
    public ResponseEntity<Optional<Participantes>> findByNome(String nome){
        return ResponseEntity.ok(participantesService.findByNome(nome));
    }

    @PutMapping("/updateParticipantes")
    public ResponseEntity<Participantes> updateParticipantes(@PathVariable UUID id,@RequestBody Participantes participantes) throws Exception {
        participantesService.updateParticipantes(id,participantes);
        return ResponseEntity.ok(participantes);
    }

    @PostMapping("/insertParticipantes")
    public ResponseEntity<Participantes> insertParticipantes(@RequestBody Participantes participantes){
        participantesService.insertParticipantes(participantes);
        return ResponseEntity.ok(participantes);
    }

    @DeleteMapping("/deleteParticipantes")
    public ResponseEntity<Participantes> deleteParticipantes(UUID id){
        participantesService.deleteParticipante(id);
        return ResponseEntity.ok().build();
    }


}
