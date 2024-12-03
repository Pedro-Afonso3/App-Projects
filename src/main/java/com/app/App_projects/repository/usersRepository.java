package com.app.App_projects.repository;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface usersRepository extends JpaRepository<Users,UUID> {

    Optional<Users> findByLogin(String login);
}
