package com.guarino.gatherlyapi.infrastructure.web.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDTO(
        ZonedDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path,
        Map<String, String> details
){}