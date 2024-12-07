package com.app.App_projects.controller;

import com.app.App_projects.DTO.ProjetosDTO;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.services.projetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
@Tag(name = "Projetos", description ="Controller para Projetos")
public class projetoController {

    @Autowired
    private projetoService projetoService;

    //CADASTRO PROJETO
    @PostMapping("/insertProjetos")
    @Operation(summary = "Cadastrar Projeto", description = "Cadastrar um novo projeto")
    public ResponseEntity<ProjetosDTO> insertProjeto(@RequestBody ProjetosDTO projetosDTO){
        projetoService.insertProjeto(projetosDTO);
        return ResponseEntity.ok(projetosDTO);
    }

    //BUSCA POR TODOS
    @GetMapping("/showAll")
    @Operation(summary = "Consultar todos", description = "Consultar todos projetos")
    public ResponseEntity<Iterable<ProjetosDTO>> showAllProjetos(){
        return ResponseEntity.ok(projetoService.showAllProjetos());
    }

    //BUSCA POR ID
    @GetMapping("/showById")
    @Operation(summary = "Consultar por ID", description = "Consultar os projetos por ID")
    public ResponseEntity<Optional<ProjetosDTO>> showById(@PathVariable UUID id){
        return ResponseEntity.ok(projetoService.showById(id));
    }

    //BUSCAR POR ID
    @GetMapping("/findByTitulo")
    @Operation(summary = "Consultar por ID", description = "Consultar os projetos por ID")
    public ResponseEntity<Optional<ProjetosDTO>> findByTitulo(String titulo){
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    //ATUALIZAR POR ID
    @PutMapping("/updateProjetos")
    @Operation(summary = "Atualizar Projetos", description = "Atualizar projetos por ID")
    public ResponseEntity<Projetos> updateProjeto(@PathVariable UUID id,@RequestBody Projetos projetos) throws Exception {
        projetoService.updateProjeto(id,projetos);
        return ResponseEntity.ok(projetos);
    }

    //DELETAR POR ID
    @DeleteMapping("/deleteProjetos")
    @Operation(summary = "Deletrar Projetos", description = "Deletar projetos por ID")
    public ResponseEntity<Projetos> deleteProjeto(UUID id){
        projetoService.deleteProjeto(id);
        return ResponseEntity.ok().build();
    }
}
