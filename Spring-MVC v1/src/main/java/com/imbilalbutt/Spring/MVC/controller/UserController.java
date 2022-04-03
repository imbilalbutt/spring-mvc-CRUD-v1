package com.imbilalbutt.Spring.MVC.controller;

import com.imbilalbutt.Spring.MVC.api.UserApi;
import com.imbilalbutt.Spring.MVC.dto.UserDTO;
import com.imbilalbutt.Spring.MVC.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractCRUDController<User, UserDTO> {

    private UserApi service;

    @Autowired
    public UserController(final UserApi service) {
        super(service);
    }
}
