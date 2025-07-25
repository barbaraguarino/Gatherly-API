package com.guarino.gatherlyapi.infrastructure.web.dto.request;

import com.guarino.gatherlyapi.infrastructure.web.validation.NormalizeEmail;
import com.guarino.gatherlyapi.infrastructure.web.validation.TrimString;
import com.guarino.gatherlyapi.infrastructure.web.validation.password.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequestDTO (

    @NotBlank(message = "{name.not.blank}")
    @TrimString
    String name,

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.invalid.format}")
    @TrimString
    @NormalizeEmail
    String email,

    @NotBlank(message = "{password.not.blank}")
    @ValidPassword
    String password
){}
