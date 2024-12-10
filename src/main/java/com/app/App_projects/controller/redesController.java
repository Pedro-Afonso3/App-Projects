package com.app.App_projects.controller;

import com.app.App_projects.DTO.RedesDTO;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.services.redesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/redes")
@Tag(name = "Redes", description ="Controller para Redes")
public class redesController {

    @Autowired
    redesService redesService;

    @GetMapping("/showAll")
    @Operation(summary = "Consultar todas", description = "Consultar todas as redes")
    public ResponseEntity<Iterable<RedesDTO>> showAllRedes(){
        return ResponseEntity.ok(redesService.showAllRedes());
    }

    @GetMapping("/findById")
    @Operation(summary = "Consultar por Id", description = "Consultar uma rede por Id")
    public ResponseEntity<Optional<RedesDTO>> findById(UUID id){
        return ResponseEntity.ok(redesService.findById(id));
    }

    @GetMapping("/findByNome")
    @Operation(summary = "Consultar por Nome", description = "Consultar uma rede por nome")
    public ResponseEntity<Optional<RedesDTO>> findByNome(String nome){
        return ResponseEntity.ok(redesService.findByNome(nome));
    }

    @PutMapping("/updateParticipantes")
    @Operation(summary = "Atualizar Redes", description = "Atualizar uma rede")
    public ResponseEntity<Redes> updateParticipantes(@PathVariable UUID id,@RequestBody Redes redes) throws Exception {
        redesService.updateRedes(id,redes);
        return ResponseEntity.ok(redes);
    }

    @PostMapping("/insertRedes")
    @Operation(summary = "Cadastrar Redes", description = "Cadastrar uma nova rede")
    public ResponseEntity<RedesDTO> insertRedes(@RequestBody RedesDTO redesDTO){
        redesService.insertRedes(redesDTO);
        return ResponseEntity.ok(redesDTO);
    }

    @DeleteMapping("/deleteRedes")
    @Operation(summary = "Deletar Redes", description = "Deletar uma rede por Id")
    public ResponseEntity<Redes> deleteRedes(UUID id){
        redesService.deleteRedes(id);
        return ResponseEntity.ok().build();
    }
}
