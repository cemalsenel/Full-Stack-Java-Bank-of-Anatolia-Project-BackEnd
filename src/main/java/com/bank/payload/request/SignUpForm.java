package com.bank.payload.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class SignUpForm {

    @NotBlank
    @Size(max=50)
    private String firstName;

    @NotBlank
    @Size(max=50)
    private String lastName;

    @NotBlank
    @Size(min=3, max=10)
    private String username;

    @NotBlank
    @Email(message = "Please provide a valid email.")
    @Size(max=50)
    private String email;

    private Set<String> role;
}
