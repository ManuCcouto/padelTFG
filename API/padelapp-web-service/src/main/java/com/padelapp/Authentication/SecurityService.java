package com.padelapp.Authentication;

import com.padelapp.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetails.class);
    public   boolean isOwner(Authentication authentication, String username) {
        logger.info("Authentication authentication {}, String username {} ",username+ authentication);
        User authenticatedUser = (User) authentication.getPrincipal();
        return authenticatedUser.getTelegramUsername().equals(username);
    }
}
