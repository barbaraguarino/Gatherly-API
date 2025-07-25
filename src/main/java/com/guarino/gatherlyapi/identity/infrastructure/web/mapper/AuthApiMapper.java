package com.guarino.gatherlyapi.identity.infrastructure.web.mapper;

import com.guarino.gatherlyapi.identity.application.port.in.RegisterUserCommand;
import com.guarino.gatherlyapi.identity.domain.model.User;
import com.guarino.gatherlyapi.shared.infrastructure.translator.EnumTranslator;
import com.guarino.gatherlyapi.identity.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.identity.infrastructure.web.dto.response.RegisterUserResponseDTO;

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

    public RegisterUserResponseDTO toSimpleResponse(User user) {
        return new RegisterUserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                enumTranslator.translate(user.getRole())
        );
    }
}