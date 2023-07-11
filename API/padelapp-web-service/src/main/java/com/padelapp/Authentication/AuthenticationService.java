package com.padelapp.Authentication;


import com.api.model.AuthenticationResponse;
import com.api.model.UserDTO;
import com.padelapp.config.JwtService;
import com.padelapp.entities.User;
import com.padelapp.entities.UserRole;
import com.padelapp.exception.AuthenticateException;
import com.padelapp.model.exception.ResourceFoundException;
import com.padelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
    @RequiredArgsConstructor
    public class AuthenticationService {
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        @Autowired
        private  AuthenticationManager authenticationManager;
        private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

        public AuthenticationResponse register(UserDTO request) {
            var user = User.builder()
                    .name(request.getFirstName())
                    .surname(request.getLastName())
                    .telegramUsername(request.getUsername())
                    .createTime(LocalDateTime.now())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .roles(Collections.singletonList(UserRole.USER))
                    .build();
            var savedUser = repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
          //  saveUserToken(savedUser, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }

        public AuthenticationResponse authenticate(String username, String password)  {
            logger.info("pass " + passwordEncoder.encode(password));
            try {
                        authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                username,
                                password
                        )

                );
            }catch (AuthenticationException e){
                throw new AuthenticateException(e.toString());

            }


            var user = repository.findByEmail(username)
                    .orElseThrow(() -> new ResourceFoundException("Usuario o contraseña incorrecto"));
            logger.info("user "+ user);

            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
          //  revokeAllUserTokens(user);
          //  saveUserToken(user, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }

}
