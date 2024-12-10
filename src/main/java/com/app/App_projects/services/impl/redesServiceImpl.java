package com.app.App_projects.services.impl;

import com.app.App_projects.DTO.ParticipantesDTO;
import com.app.App_projects.DTO.RedesDTO;
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
    public void insertRedes(RedesDTO redesDTO) {
        Redes redes = convertToEntity(redesDTO);
        repository.save(redes);
    }

    //Convert RedesDTO to Redes
    private Redes convertToEntity(RedesDTO redesDTO) {
        Redes redes = new Redes();
        redes.setId((redesDTO.getId()));
        redes.setNome(redesDTO.getNome());
        redes.setLinkRedes(redesDTO.getLinkRedes());
        redes.setCodRedes(redesDTO.getCodRedes());
        redes.setParticipantes(redesDTO.getParticipantesList());
        return redes;
    }

    //Converte Projetos para ProjetosDTO
    private RedesDTO convertToDTO(Redes redes){
        RedesDTO redesDTO = new RedesDTO();
        redesDTO.setId(redes.getId());
        redesDTO.setNome(redes.getNome());
        redesDTO.setLinkRedes(redes.getLinkRedes());
        redesDTO.setCodRedes(redes.getCodRedes());
        redesDTO.setParticipantesList((List<ParticipantesDTO>) redes.getParticipantes());
        return redesDTO;
    }

    @Override
    public void updateRedes(UUID id, Redes redes) throws Exception {
        Optional<Redes> redes1 = repository.findById(id);

        if (redes1.isPresent()) {
            Redes redesExists = redes1.get();

            if (redes.getNome() != null) {
                redesExists.setNome(redes.getNome());
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
    public List<RedesDTO> showAllRedes() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public Optional<RedesDTO> findById(UUID id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public Optional<RedesDTO> findByNome(String nome) {
        return  repository.findByNome(nome)
                .map(this::convertToDTO);
    }
}
