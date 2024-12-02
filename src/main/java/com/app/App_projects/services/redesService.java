package com.app.App_projects.services;

import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.repository.redesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface redesService {

    void insertRedes(Redes redes);

    void updateRedes(UUID id, Redes redes) throws Exception;

    void deleteRedes(UUID id);

    List<Redes> showAllRedes();

    Optional<Redes> showById(UUID id);

    Optional<Redes> findByName(String name);
}
