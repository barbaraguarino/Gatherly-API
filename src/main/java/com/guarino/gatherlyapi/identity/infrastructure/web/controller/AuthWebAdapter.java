package com.guarino.gatherlyapi.identity.infrastructure.web.controller;

import com.guarino.gatherlyapi.identity.application.port.in.RegisterUserUseCase;
import com.guarino.gatherlyapi.identity.domain.model.User;
import com.guarino.gatherlyapi.identity.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.identity.infrastructure.web.dto.response.RegisterUserResponseDTO;
import com.guarino.gatherlyapi.identity.infrastructure.web.mapper.AuthApiMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthWebAdapter {

    private final RegisterUserUseCase registerUserUseCase;
    private final AuthApiMapper authApiMapper;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDTO> registerUser(@Valid @RequestBody RegisterUserRequestDTO requestDTO) {
        var command = authApiMapper.toCommand(requestDTO);
        User createdUser = registerUserUseCase.execute(command);
        RegisterUserResponseDTO responseDto = authApiMapper.toSimpleResponse(createdUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).body(responseDto);
    }
}