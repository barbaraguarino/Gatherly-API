package com.guarino.gatherlyapi.infrastructure.web.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserSimpleResponseDTO(
        @NotNull UUID id,
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String role
){}
