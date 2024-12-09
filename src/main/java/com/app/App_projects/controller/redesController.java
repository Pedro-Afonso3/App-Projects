package com.app.App_projects.controller;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.services.redesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/redes")
public class redesController {

    @Autowired
    redesService redesService;

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<Redes>> showAllRedes(){
        return ResponseEntity.ok(redesService.showAllRedes());
    }

    @GetMapping("/showById")
    public ResponseEntity<Optional<Redes>> showById(@PathVariable UUID id){
        return ResponseEntity.ok(redesService.showById(id));
    }

    @GetMapping("/findByNome")
    public ResponseEntity<Optional<Redes>> findByNome(String nome){
        return ResponseEntity.ok(redesService.findByNome(nome));
    }

    @PutMapping("/updateParticipantes")
    public ResponseEntity<Redes> updateParticipantes(@PathVariable UUID id,@RequestBody Redes redes) throws Exception {
        redesService.updateRedes(id,redes);
        return ResponseEntity.ok(redes);
    }

    @PostMapping("/insertRedes")
    public ResponseEntity<Redes> insertRedes(@RequestBody Redes redes){
        redesService.insertRedes(redes);
        return ResponseEntity.ok(redes);
    }

    @DeleteMapping("/deleteRedes")
    public ResponseEntity<Redes> deleteRedes(UUID id){
        redesService.deleteRedes(id);
        return ResponseEntity.ok().build();
    }
}
