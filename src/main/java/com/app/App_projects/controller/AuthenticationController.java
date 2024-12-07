package com.app.App_projects.controller;

import com.app.App_projects.domain.users.AuthenticationDTO;
import com.app.App_projects.domain.users.LoginResponseDTO;
import com.app.App_projects.domain.users.RegisterDTO;
import com.app.App_projects.infra.security.TokenService;
import com.app.App_projects.domain.users.Users;
import com.app.App_projects.repository.usersRepository;

import com.app.App_projects.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private usersRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword =new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        //if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        if (this.repository.findByLogin(data.getLogin()) != null) { return ResponseEntity.badRequest().body("Erro: Usuário já existe."); }

        String encrytedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        Users newUser = new Users(data.getLogin(),encrytedPassword, data.getRole());

        String subject = "Bem-vindo ao nosso serviço!";
        String text = "Olá " + data.getLogin() + ",\n\n Obrigado por se cadastrar no nosso serviço!";
        emailService.sendEmail(data.getLogin(), subject, text);

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
