package com.humanbooster.hbexamthymeleaf.service;

import com.humanbooster.hbexamthymeleaf.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends GenericService<Project, Long> {

    public ProjectService() {
        super(StaticData.projects);
    }
}
