package com.app.App_projects.repository;
import com.app.App_projects.domain.participantes.Participantes;
import com.app.App_projects.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface usersRepository extends JpaRepository<Users,String> {

    UserDetails findByLogin(String login);
}
