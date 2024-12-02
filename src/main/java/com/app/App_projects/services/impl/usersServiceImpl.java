package com.app.App_projects.services.impl;

import com.app.App_projects.domain.redes.Redes;
import com.app.App_projects.domain.users.Users;
import com.app.App_projects.repository.usersRepository;
import com.app.App_projects.services.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersRepository repository;

    @Override
    public void insertUsers(Users users) {
        repository.save(users);
    }

    @Override
    public void updateUsers(UUID id, Users users) throws Exception {
        Optional<Users> users1 = repository.findById(id);

        if (users1.isPresent()) {
            Users usersExists = users1.get();

            if (users.getLogin() != null) {
                usersExists.setLogin(users.getLogin());
            }

            if (users.getPassword() != null) {
                usersExists.setPassword(users.getPassword());
            }

            repository.save(usersExists);
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    @Override
    public void deleteUsers(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Users> showAllUsers() {
        List<Users> resultShowAll = repository.findAll();
        return resultShowAll;
    }

    @Override
    public Optional<Users> showById(UUID id) {
        Optional<Users> resultShowId = repository.findById(id);
        return  resultShowId;
    }

    @Override
    public Optional<Users> findByLogin(String login) {
        Optional<Users> resultShowLogin = repository.findByLogin(login);
        return resultShowLogin;
    }
}
