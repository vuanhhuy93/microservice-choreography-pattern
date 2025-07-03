package vn.gtel.qtudsso.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.gtel.qtudsso.models.request.user.CreateUserRequest;
import vn.gtel.qtudsso.services.UserService;
import vn.gtel.qtudsso.utils.ApplicationException;

@RestController
@RequestMapping("/public/api/user")
@Slf4j
public class UserControllers {
    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody CreateUserRequest request) throws ApplicationException {
        userService.createUser(request);
    }


}