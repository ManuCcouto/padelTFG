package com.padelapp.controller;

import com.api.apimodel.ResourceApi;
import com.api.model.ResourceDTO;
import com.padelapp.repository.UserRepository;
import com.padelapp.service.BookingService;
import com.padelapp.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class ResourceController implements ResourceApi {

    @Autowired
    ResourceService resourceService;

    @Autowired
    BookingService bookingService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ResourceApi.super.getRequest();
    }

    @Override
    public ResponseEntity<ResourceDTO> getResourceById(Long id) {
        return ResourceApi.super.getResourceById(id);
    }
}
