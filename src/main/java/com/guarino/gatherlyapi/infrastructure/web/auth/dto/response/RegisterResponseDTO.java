package com.guarino.gatherlyapi.infrastructure.web.auth.dto.response;

import java.util.UUID;

public record RegisterResponseDTO(
        UUID id,
        String name,
        String email,
        String role
){}