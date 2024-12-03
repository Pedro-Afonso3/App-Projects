package com.app.App_projects.repository;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.projetos.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface projetosRepository extends JpaRepository<Projetos, UUID> {

    Optional<Projetos> findByTitulo(String titulo);
}
