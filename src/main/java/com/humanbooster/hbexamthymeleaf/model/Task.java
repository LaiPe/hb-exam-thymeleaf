package com.humanbooster.hbexamthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task extends GenericModel<Long> {
    private Long id;

    @Size(max = 100, message = "Le titre peut contenir au maximum 100 caractères")
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String title;

    @NotNull(message = "Une tâche doit avoir un statut")
    private TaskStatus status;

    @NotNull(message = "Une tâche doit ête assignée à un utilisateur")
    private User assignee;
}