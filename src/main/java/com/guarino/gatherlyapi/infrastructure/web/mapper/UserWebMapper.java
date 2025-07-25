package com.guarino.gatherlyapi.infrastructure.web.mapper;

import com.guarino.gatherlyapi.application.user.port.in.RegisterUserCommand;
import com.guarino.gatherlyapi.domain.user.model.User;
import com.guarino.gatherlyapi.infrastructure.translator.EnumTranslator;
import com.guarino.gatherlyapi.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.dto.response.UserSimpleResponseDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserWebMapper {

    private final EnumTranslator enumTranslator;

    public RegisterUserCommand toCommand(RegisterUserRequestDTO dto) {
        return new RegisterUserCommand(
                dto.name(),
                dto.email(),
                dto.password()
        );
    }

    public UserSimpleResponseDTO toSimpleResponse(User user) {
        return new UserSimpleResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                enumTranslator.translate(user.getRole())
        );
    }
}