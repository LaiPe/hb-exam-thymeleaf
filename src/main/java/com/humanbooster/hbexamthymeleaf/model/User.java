package com.humanbooster.hbexamthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends GenericModel<Long> {
    private Long id;

    @Size(max = 50, message = "Le nom d'utilisateur peut contenir au maximum 50 caractères")
    @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide")
    private String username;
}
