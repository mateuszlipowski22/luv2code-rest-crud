package com.luv2code.rest_application.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {

    private Integer id;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @Email(message = "Incorrect email address")
    private String email;
}
