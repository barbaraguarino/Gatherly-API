package com.guarino.gatherlyapi.infrastructure.web.auth.controller;

import com.guarino.gatherlyapi.application.user.port.in.RegisterUserUseCase;
import com.guarino.gatherlyapi.domain.user.model.User;
import com.guarino.gatherlyapi.infrastructure.web.auth.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.auth.dto.response.RegisterResponseDTO;
import com.guarino.gatherlyapi.infrastructure.web.auth.mapper.AuthApiMapper;

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
    public ResponseEntity<RegisterResponseDTO> registerUser(@Valid @RequestBody RegisterUserRequestDTO requestDTO) {
        var command = authApiMapper.toCommand(requestDTO);
        User createdUser = registerUserUseCase.execute(command);
        RegisterResponseDTO responseDto = authApiMapper.toSimpleResponse(createdUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).body(responseDto);
    }
}