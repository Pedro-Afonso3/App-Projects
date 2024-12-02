package com.app.App_projects.repository;

import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.projetos.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface projetosRepository extends JpaRepository<Projetos, UUID> {

    Optional<Projetos> findByName(String name);
}
