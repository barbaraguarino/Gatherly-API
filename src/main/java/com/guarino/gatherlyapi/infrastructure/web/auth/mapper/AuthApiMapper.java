package com.guarino.gatherlyapi.infrastructure.web.auth.mapper;

import com.guarino.gatherlyapi.application.user.port.in.RegisterUserCommand;
import com.guarino.gatherlyapi.domain.user.model.User;
import com.guarino.gatherlyapi.infrastructure.translator.EnumTranslator;
import com.guarino.gatherlyapi.infrastructure.web.auth.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.auth.dto.response.RegisterResponseDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthApiMapper {

    private final EnumTranslator enumTranslator;

    public RegisterUserCommand toCommand(RegisterUserRequestDTO dto) {
        return new RegisterUserCommand(
                dto.name(),
                dto.email(),
                dto.password()
        );
    }

    public RegisterResponseDTO toSimpleResponse(User user) {
        return new RegisterResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                enumTranslator.translate(user.getRole())
        );
    }
}