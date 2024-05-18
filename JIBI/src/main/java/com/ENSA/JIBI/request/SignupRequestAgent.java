package com.ENSA.JIBI.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignupRequestAgent {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @NotBlank
    @Size(min = 2, max = 40)
    private String password;

    @NotBlank
    @Size(min = 2, max = 40)
    private String  nom;
    @NotBlank
    @Size(min = 2, max = 40)
    private String  prenom;
    @NotBlank
    @Size(min = 2, max = 40)
    private String  pieceIdentite;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numPieceIdentite;
    @NotBlank

    private Date dateNaissance;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  adresse;
    @NotBlank
    @Size(min = 2, max = 40)

    private String  numTel;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numMatriculation;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numPattente;

}
