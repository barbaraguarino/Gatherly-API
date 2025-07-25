package com.guarino.gatherlyapi.infrastructure.web.mapper;

import com.guarino.gatherlyapi.application.port.in.user.RegisterUserCommand;
import com.guarino.gatherlyapi.domain.model.user.User;
import com.guarino.gatherlyapi.infrastructure.translator.EnumTranslator;
import com.guarino.gatherlyapi.infrastructure.web.dto.request.RegisterUserRequestDTO;
import com.guarino.gatherlyapi.infrastructure.web.dto.response.UserSimpleResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserWebMapper {

    private final EnumTranslator enumTranslator;

    public UserWebMapper(EnumTranslator enumTranslator) {
        this.enumTranslator = enumTranslator;
    }

    public RegisterUserCommand toCommand(RegisterUserRequestDTO dto) {
        return new RegisterUserCommand(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
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
