package com.padelapp.controller;

import com.api.apimodel.FestiveApi;
import com.api.model.FestiveDTO;
import com.padelapp.model.service.FestiveServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FestiveController implements FestiveApi {
    private static final Logger logger = LoggerFactory.getLogger(FestiveController.class);
    @Autowired
    private FestiveServiceImpl festiveService;
    private Authentication authentication;

    @Override
    public Optional<NativeWebRequest> getRequest() {

        return FestiveApi.super.getRequest();
    }


    @Override
    public ResponseEntity<FestiveDTO> getFestivebyId(Integer idfestive) {
        var auth =  SecurityContextHolder.getContext().getAuthentication();
        log.info("Datos del Usuario: {} ", auth.getPrincipal());
        logger.info("Datos de los Permisos "+ auth.getAuthorities());
        logger.info("Esta autenticado "+ auth.isAuthenticated());

        return ResponseEntity.ok( this.festiveService.getFestiveById(idfestive));
    }

}
