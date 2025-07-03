package com.humanbooster.hbexamthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Long id;

    @Size(max = 100, message = "Le nom peut contenir au maximum 100 caractères")
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String name;

    @NotNull(message = "Un projet doit avoir un créateur")
    private User creator;


    private List<Task> tasks = new ArrayList<>();
}
