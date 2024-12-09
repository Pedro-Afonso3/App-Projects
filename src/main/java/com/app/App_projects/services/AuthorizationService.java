package com.app.App_projects.services;

import com.app.App_projects.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    usersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        return repository.findByLogin(login);
    }

}
