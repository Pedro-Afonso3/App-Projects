package com.app.App_projects.controller;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.users.Users;
import com.app.App_projects.services.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users") // PROVAVELMENTE NÃO VAI SER UTIL DELETAR SE NECESSÁRIO
public class usersController {

    @Autowired
    usersService usersService;

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<Users>> showAllUsers(){
        return ResponseEntity.ok(usersService.showAllUsers());
    }

    @GetMapping("/showById")
    public ResponseEntity<Optional<Users>> showById(@PathVariable UUID id){
        return ResponseEntity.ok(usersService.showById(id));
    }

    @GetMapping("/findByLogin")
    public ResponseEntity<Optional<Users>> findByLogin(String login){
        return ResponseEntity.ok(usersService.findByLogin(login));
    }

    @PutMapping("/updateUsers")
    public ResponseEntity<Users> updateUsers(@PathVariable UUID id,@RequestBody Users users) throws Exception {
        usersService.updateUsers(id,users);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/insertUsers")
    public ResponseEntity<Users> insertUsers(@RequestBody Users users){
        usersService.insertUsers(users);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/deleteUsers")
    public ResponseEntity<Users> deleteUsers(UUID id){
        usersService.deleteUsers(id);
        return ResponseEntity.ok().build();
    }
}
