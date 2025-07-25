package com.guarino.gatherlyapi.infrastructure.web.exception;

import com.guarino.gatherlyapi.domain.user.exception.EmailAlreadyExistsException;
import com.guarino.gatherlyapi.infrastructure.web.dto.response.ErrorResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmailAlreadyExists(final EmailAlreadyExistsException ex, final WebRequest request) {
        String message = resolveMessage("error.email.exists", new Object[]{ex.getEmail()}, request);
        return buildErrorResponse(HttpStatus.CONFLICT, message, null, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(final MethodArgumentNotValidException ex, final WebRequest request) {
        Map<String, String> validationErrors = ex.getBindingResult().getFieldErrors().stream()
                .filter(error -> Objects.nonNull(error.getDefaultMessage()))
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existingValue, newValue) -> newValue
                ));

        String message = resolveMessage("error.validation", null, request);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message, validationErrors, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(final Exception ex, final WebRequest request) {
        log.error("Unhandled exception caught: {}", ex.getMessage(), ex);
        String message = resolveMessage("error.unexpected", null, request);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, null, request);
    }

    private ResponseEntity<ErrorResponseDTO> buildErrorResponse(final HttpStatus status, final String message, final Map<String, String> details, final WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ErrorResponseDTO errorDto = new ErrorResponseDTO(
                ZonedDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path,
                details
        );
        return new ResponseEntity<>(errorDto, status);
    }

    private String resolveMessage(final String key, final Object[] args, final WebRequest request) {
        return messageSource.getMessage(key, args, request.getLocale());
    }
}