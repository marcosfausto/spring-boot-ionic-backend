package com.marcosfausto.cursomc.services;

import com.marcosfausto.cursomc.security.UserSS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

}
