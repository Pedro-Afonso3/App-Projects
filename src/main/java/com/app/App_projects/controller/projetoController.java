package com.app.App_projects.controller;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.services.participantesService;
import com.app.App_projects.services.projetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
public class projetoController {

    @Autowired
    projetoService projetoService;

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<Projetos>> showAllProjetos(){
        return ResponseEntity.ok(projetoService.showAllProjetos());
    }

    @GetMapping("/showById")
    public ResponseEntity<Optional<Projetos>> showById(@PathVariable UUID id){
        return ResponseEntity.ok(projetoService.showById(id));
    }

    @GetMapping("/findByTitulo")
    public ResponseEntity<Optional<Projetos>> findByTitulo(String titulo){
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    @PutMapping("/updateProjetos")
    public ResponseEntity<Projetos> updateProjeto(@PathVariable UUID id,@RequestBody Projetos projetos) throws Exception {
        projetoService.updateProjeto(id,projetos);
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/insertProjetos")
    public ResponseEntity<Projetos> insertProjeto(@RequestBody Projetos projetos){
        projetoService.insertProjeto(projetos);
        return ResponseEntity.ok(projetos);
    }

    @DeleteMapping("/deleteProjetos")
    public ResponseEntity<Projetos> deleteProjeto(UUID id){
        projetoService.deleteProjeto(id);
        return ResponseEntity.ok().build();
    }
}
