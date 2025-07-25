package com.guarino.gatherlyapi.infrastructure.web.controller;

import com.guarino.gatherlyapi.application.user.port.in.RegisterUserUseCase;
import com.guarino.gatherlyapi.domain.user.model.User;
import com.guarino.gatherlyapi.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.dto.response.UserSimpleResponseDTO;
import com.guarino.gatherlyapi.infrastructure.web.mapper.UserApiMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserWebAdapter {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserApiMapper userApiMapper;

    @PostMapping("/register")
    public ResponseEntity<UserSimpleResponseDTO> registerUser(@Valid @RequestBody RegisterUserRequestDTO requestDTO) {
        var command = userApiMapper.toCommand(requestDTO);
        User createdUser = registerUserUseCase.execute(command);
        UserSimpleResponseDTO responseDto = userApiMapper.toSimpleResponse(createdUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).body(responseDto);
    }
}