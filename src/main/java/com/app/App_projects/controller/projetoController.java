package com.app.App_projects.controller;

import com.app.App_projects.DTO.ProjetosDTO;
import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.services.projetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
@Tag(name = "Projetos", description ="Controller para Projetos")
public class projetoController {

    @Autowired
    private projetoService projetoService;

    List<ProjetosDTO> projetosDTOList = new ArrayList<>();

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
    @GetMapping("/findById")
    @Operation(summary = "Consultar por ID", description = "Consultar os projetos por ID")
    public ResponseEntity<Optional<ProjetosDTO>> findById(UUID id){
        return ResponseEntity.ok(projetoService.findById(id));
    }

    //BUSCAR POR Titulo
    @GetMapping("/findByTitulo")
    @Operation(summary = "Consultar por titulo", description = "Consultar os projetos por titulo")
    public ResponseEntity<Optional<ProjetosDTO>> findByTitulo(String titulo){
        return ResponseEntity.ok(projetoService.findByTitulo(titulo));
    }

    //ATUALIZAR POR ID
    @PutMapping("/updateProjetos")
    @Operation(summary = "Atualizar Projetos", description = "Atualizar projetos por ID")
    public ResponseEntity<Projetos> updateProjeto(UUID id,@RequestBody Projetos projetos) throws Exception {
        projetoService.updateProjeto(id,projetos);
        return ResponseEntity.ok(projetos);
    }

    //DELETAR POR ID
    @DeleteMapping("/deleteProjetos")
    @Operation(summary = "Deletar Projetos", description = "Deletar projetos por ID")
    public ResponseEntity<Projetos> deleteProjeto(UUID id){
        projetoService.deleteProjeto(id);
        return ResponseEntity.ok().build();
    }

    //PARA PUXAR NO THYMELEAF -- Linguagem


}
