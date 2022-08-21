package com.marcosfausto.cursomc.services;

import com.marcosfausto.cursomc.domain.Cliente;
import com.marcosfausto.cursomc.repositories.ClienteRepository;
import com.marcosfausto.cursomc.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClienteRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cli = repository.findByEmail(email);
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
    }
}
