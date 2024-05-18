package com.ENSA.JIBI.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


public class SignupRequestClient {
    @NotBlank
    @Size(min = 3, max = 40)
    private String nom;
    @NotBlank
    @Size(min = 3, max = 40)
    private String prenom;
    @NotBlank
    @Size(min = 3, max = 20)
    private String numTel;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 80)
    @Email
    private String email;



    @NotBlank
    @Size(min = 2, max = 80)
    private String password;


}
