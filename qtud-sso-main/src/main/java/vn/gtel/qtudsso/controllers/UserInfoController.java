package vn.gtel.qtudsso.controllers;

import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserInfoController {

//    @GetMapping("/userinfo")
//    public Map<String, Object> userinfo(OAuth2AuthenticationToken authentication) {
//        OAuth2AuthenticatedPrincipal principal = authentication.getPrincipal();
//        return Map.of(
//                "username", principal.getAttribute("username"),
//                "authorities", principal.getAuthorities()
//        );
//    }
}
