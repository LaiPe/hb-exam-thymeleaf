package com.humanbooster.hbexamthymeleaf.controller;

import com.humanbooster.hbexamthymeleaf.model.Project;
import com.humanbooster.hbexamthymeleaf.model.Task;
import com.humanbooster.hbexamthymeleaf.model.TaskStatus;
import com.humanbooster.hbexamthymeleaf.model.User;
import com.humanbooster.hbexamthymeleaf.service.ProjectService;
import com.humanbooster.hbexamthymeleaf.service.TaskService;
import com.humanbooster.hbexamthymeleaf.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final ProjectService projectService;

    @GetMapping("/create")
    public String getCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.getEntities());
        model.addAttribute("users", userService.getEntities());
        return "task-create";
    }

    @PostMapping("/create")
    public String createTask(@Valid @ModelAttribute Task task,
                             @RequestParam Long projectId,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            // Re-populate the model attributes for the form
            model.addAttribute("projects", projectService.getEntities());
            model.addAttribute("users", userService.getEntities());
            return "task-create";
        }

        Optional<User> assigneeOpt = userService.getEntityById(task.getAssignee().getId());
        Optional<Project> projectOpt = projectService.getEntityById(projectId);

        if (assigneeOpt.isPresent() && projectOpt.isPresent()) {
            User assignee = assigneeOpt.get();
            Project project = projectOpt.get();

            task.setAssignee(assignee);

            // Save the task first
            Task savedTask = taskService.addEntity(task);

            // Add task to project's task list
            List<Task> projectTasks = project.getTasks();
            projectTasks.add(savedTask);
            project.setTasks(projectTasks);
            projectService.addEntity(project);

            return "redirect:/projects";
        } else {
            bindingResult.reject("error.creator", "Formulaire incomplet");
            // Re-populate the model attributes for the form
            model.addAttribute("projects", projectService.getEntities());
            model.addAttribute("users", userService.getEntities());
            return "task-create";
        }
    }
}