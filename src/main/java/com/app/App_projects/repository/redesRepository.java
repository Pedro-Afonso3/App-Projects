package com.app.App_projects.repository;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.redes.Redes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface redesRepository extends JpaRepository<Redes,UUID> {

    Optional<Redes> findByNome(String nome);
}
