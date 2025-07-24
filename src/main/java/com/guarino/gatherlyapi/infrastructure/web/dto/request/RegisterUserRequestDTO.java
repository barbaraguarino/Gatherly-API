package com.guarino.gatherlyapi.infrastructure.web.dto.request;

import com.guarino.gatherlyapi.infrastructure.web.validation.password.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterUserRequestDTO {

    @NotBlank(message = "{name.not.blank}")
    String name;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.invalid.format}")
    String email;

    @NotBlank(message = "{password.not.blank}")
    @ValidPassword
    String password;
}
