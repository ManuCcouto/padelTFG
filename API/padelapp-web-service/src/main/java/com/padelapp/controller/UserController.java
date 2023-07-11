package com.padelapp.controller;

import com.api.apimodel.UserApi;
import com.api.model.AuthenticationResponse;
import com.api.model.BookingDTO;
import com.api.model.UserDTO;
import com.padelapp.Authentication.AuthenticationService;
import com.padelapp.Authentication.SecurityService;
import com.padelapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {


    private final AuthenticationService service;
    private final UserRepository userRepository;
    private SecurityService securityService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        AuthenticationResponse auhenticate = this.service.register(userDTO);

        logger.info(auhenticate.toString());
        return UserApi.super.createUser(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> createUsersWithListInput(List<UserDTO> userDTO) {
        return UserApi.super.createUsersWithListInput(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> getUserByName(String username) {
        return UserApi.super.getUserByName(username);
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, UserDTO userDTO) {
        return UserApi.super.updateUser(username, userDTO);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return UserApi.super.deleteUser(username);
    }


    @Override
    public ResponseEntity<List<BookingDTO>> getBookingsUser(String username) {


        var auth =  SecurityContextHolder.getContext().getAuthentication();
        logger.info("Datos del Usuario: "+ auth.getPrincipal());
        logger.info("Datos de los Permisos "+ auth.getAuthorities());
        logger.info("Esta autenticado "+ auth.isAuthenticated());
        return UserApi.super.getBookingsUser(username);
    }





    @Override
    public ResponseEntity<String> loginUser(String username, String password) {

        logger.info("estamos dentro usename "+ username);

        logger.info("despues " + this.userRepository.findByEmail(username).toString());
        // Crear las cabeceras HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-User-Info", (this.service.authenticate(username,password).getAccessToken()));

        // Crear la respuesta HTTP con las cabeceras
        return ResponseEntity.ok()
                .headers(headers)
                .body("La solicitud ha sido procesada correctamente.");
    }



    @Override
    public ResponseEntity<Void> logoutUser() {
        return UserApi.super.logoutUser();
    }




}
