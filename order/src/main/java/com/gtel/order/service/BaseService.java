package com.gtel.order.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseService {


    public String getUsername() {
        Authentication authentication =   SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
