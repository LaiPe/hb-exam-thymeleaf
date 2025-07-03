package com.humanbooster.hbexamthymeleaf.service;

import com.humanbooster.hbexamthymeleaf.model.Project;
import com.humanbooster.hbexamthymeleaf.model.Task;
import com.humanbooster.hbexamthymeleaf.model.TaskStatus;
import com.humanbooster.hbexamthymeleaf.model.User;

import java.util.List;

public class StaticData {

    public static List<User> users = List.of(
            new User(1L,"leopey"),
            new User(2L, "quentcas"),
            new User(3L, "bilelalm")
    );

    public static List<Task> tasks = List.of(
            new Task(
                    1L,
                    "Tâche super cool à faire",
                    TaskStatus.DONE,
                    users.get(0)
            ),
            new Task(
                    2L,
                    "Tâche de mec fainéant",
                    TaskStatus.IN_PROGRESS,
                    users.get(1)
            ),
            new Task(
                    3L,
                    "Tâche nulle à faire",
                    TaskStatus.TODO,
                    users.get(2)
            ),
            new Task(
                    4L,
                    "Tâche compliquée",
                    TaskStatus.TODO,
                    users.get(0)
            ),
            new Task(
                    5L,
                    "Tâche maudite",
                    TaskStatus.TODO,
                    users.get(1)
            )
    );

    public static List<Project> projects = List.of(
            new Project(
                    1L,
                    "Projet trop cool",
                    users.get(0),
                    List.of(tasks.get(0), tasks.get(1), tasks.get(2))
            ),
            new Project(
                    2L,
                    "Projet cursed du brésil",
                    users.get(1),
                    List.of(tasks.get(3), tasks.get(4))
            )
    );


}
