package com.padelapp.controller;

import com.api.apimodel.BackofficeApi;
import com.api.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BackofficeController implements BackofficeApi {


    @Override
    public ResponseEntity<Void> deleteResource(Long id) {
        return BackofficeApi.super.deleteResource(id);
    }

    @Override
    public ResponseEntity<ResourceDTO> updateResource(Long id, InputResourceDTO inputResourceDTO) {
        return BackofficeApi.super.updateResource(id, inputResourceDTO);
    }

    @Override
    public ResponseEntity<Void> deleteFestive(Integer idfestive) {
        return BackofficeApi.super.deleteFestive(idfestive);
    }

    @Override
    public ResponseEntity<Void> updateFestive(Integer idfestive, FestiveDTO festiveDTO) {
        return BackofficeApi.super.updateFestive(idfestive, festiveDTO);
    }

    @Override
    public ResponseEntity<BookingDTO> backOfficeAddBooking(InlineObject inlineObject) {
        return BackofficeApi.super.backOfficeAddBooking(inlineObject);
    }
}
