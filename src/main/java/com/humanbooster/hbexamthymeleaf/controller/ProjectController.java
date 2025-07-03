package com.humanbooster.hbexamthymeleaf.controller;

import com.humanbooster.hbexamthymeleaf.model.Project;
import com.humanbooster.hbexamthymeleaf.model.User;
import com.humanbooster.hbexamthymeleaf.service.ProjectService;
import com.humanbooster.hbexamthymeleaf.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @GetMapping
    public String getProjects(Model model) {
        model.addAttribute("projects", projectService.getEntities());
        return "projects";
    }

    @GetMapping("/{id}")
    public String getProjectById(@PathVariable("id") Long id, Model model) {
        projectService.getEntityById(id)
                .map(project -> model.addAttribute("project", project));
        return "project";
    }

    @GetMapping("/create")
    public String getProjectCreateForm(Model model) {
        model.addAttribute("users", userService.getEntities());
        model.addAttribute("project", new Project());
        return "project-create";
    }

    @PostMapping("/create")
    public String createProject(@Valid @ModelAttribute Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project-create";
        }

        Optional<User> creator = userService.getEntityById(project.getCreator().getId());
        if (creator.isPresent()) {
            project.setCreator(creator.get());
            projectService.addEntity(project);
            return "redirect:/projects";
        } else {
            bindingResult.reject("error.creator", "Créateur inexistant");
            return "project-create";
        }

    }



}
