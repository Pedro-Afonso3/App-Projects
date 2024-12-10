package com.app.App_projects.repository;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.redes.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface redesRepository extends JpaRepository<Redes,UUID> {

    Optional<Redes> findByNome(String nome);


}
