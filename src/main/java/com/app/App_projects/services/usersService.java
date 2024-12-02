package com.app.App_projects.services;

import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.domain.users.Users;
import com.app.App_projects.repository.participantesRepository;
import com.app.App_projects.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface usersService {

    void insertUsers(Users users);

    void updateUsers(UUID id, Users users) throws Exception;

    void deleteUsers(UUID id);

    List<Users> showAllUsers();

    Optional<Users> showById(UUID id);

    Optional<Users> findByLogin(String login);
}
