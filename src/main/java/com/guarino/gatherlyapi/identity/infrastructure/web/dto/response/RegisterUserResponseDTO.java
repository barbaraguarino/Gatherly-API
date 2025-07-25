package com.guarino.gatherlyapi.identity.infrastructure.web.dto.response;

import java.util.UUID;

public record RegisterUserResponseDTO(
        UUID id,
        String name,
        String email,
        String role
){}