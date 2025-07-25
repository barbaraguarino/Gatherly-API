package com.guarino.gatherlyapi.infrastructure.web.dto.response;

import java.util.UUID;

public record UserSimpleResponseDTO(
        UUID id,
        String name,
        String email,
        String role
){}
