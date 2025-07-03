package com.humanbooster.hbexamthymeleaf.service;

import com.humanbooster.hbexamthymeleaf.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    public UserService() {
        super(StaticData.users);
    }
}
