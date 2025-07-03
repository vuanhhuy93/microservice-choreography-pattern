package vn.gtel.qtudsso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.gtel.qtudsso.models.request.authentication.LoginRequest;
import vn.gtel.qtudsso.models.response.authentication.LoginResponse;
import vn.gtel.qtudsso.services.AuthenticationService;
import vn.gtel.qtudsso.utils.ApplicationException;

@RestController
public class AuthenticationControllers {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws ApplicationException {
        return authenticationService.login(loginRequest);
    }
}
