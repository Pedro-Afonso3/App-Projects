package com.app.App_projects.services.impl;

import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.repository.redesRepository;
import com.app.App_projects.services.redesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class redesServiceImpl implements redesService {

    @Autowired
    private redesRepository repository;

    @Override
    public void insertRedes(Redes redes) {
        repository.save(redes);
    }

    @Override
    public void updateRedes(UUID id, Redes redes) throws Exception {
        Optional<Redes> redes1 = repository.findById(id);

        if (redes1.isPresent()) {
            Redes redesExists = redes1.get();

            if (redes.getName() != null) {
                redesExists.setName(redes.getName());
            }

            if (redes.getLinkRedes() != null) {
                redesExists.setLinkRedes(redes.getLinkRedes());
            }

            repository.save(redesExists);
        } else {

            throw new Exception("Redes não encontrado");
        }
    }

    @Override
    public void deleteRedes(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Redes> showAllRedes() {
        List<Redes> resultShowAll = repository.findAll();
        return resultShowAll;
    }

    @Override
    public Optional<Redes> showById(UUID id) {
        Optional<Redes> resultShowId = repository.findById(id);
        return  resultShowId;
    }

    @Override
    public Optional<Redes> findByName(String name) {
        Optional<Redes> resultShowName = repository.findByName(name);
        return resultShowName;
    }
}
