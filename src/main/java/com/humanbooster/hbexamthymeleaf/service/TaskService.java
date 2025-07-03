package com.humanbooster.hbexamthymeleaf.service;

import com.humanbooster.hbexamthymeleaf.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends GenericService<Task, Long> {

    public TaskService() {
        super(StaticData.tasks);
    }
}
