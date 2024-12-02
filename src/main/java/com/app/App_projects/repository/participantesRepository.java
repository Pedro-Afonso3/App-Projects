package com.app.App_projects.repository;


import com.app.App_projects.domain.participantes.Participantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface participantesRepository extends JpaRepository<Participantes, UUID> {

    Optional<Participantes> findByName(String name);
}
