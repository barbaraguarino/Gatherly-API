package com.guarino.gatherlyapi.infrastructure.web.controller;

import com.guarino.gatherlyapi.application.port.in.user.RegisterUserUseCase;
import com.guarino.gatherlyapi.domain.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.domain.model.user.User;
import com.guarino.gatherlyapi.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.dto.response.UserSimpleResponseDTO;
import com.guarino.gatherlyapi.infrastructure.web.mapper.UserWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserWebMapper userWebMapper;

    public UserController(RegisterUserUseCase registerUserUseCase, UserWebMapper userWebMapper) {
        this.registerUserUseCase = registerUserUseCase;
        this.userWebMapper = userWebMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserSimpleResponseDTO> registerUser(@Valid @RequestBody RegisterUserRequestDTO requestDTO) {
        var command = userWebMapper.toCommand(requestDTO);
        User createdUser = registerUserUseCase.execute(command);
        UserSimpleResponseDTO responseDto = userWebMapper.toSimpleResponse(createdUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).body(responseDto);
    }
}
