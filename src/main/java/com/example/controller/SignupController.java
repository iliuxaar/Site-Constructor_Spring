package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class SignupController {
    private final ProviderSignInUtils signInUtils;

    private final SimpleGrantedAuthority user = new SimpleGrantedAuthority("ROLE_USER");

    private final SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");

    @Autowired
    UserService userService;

    @Autowired
    public SignupController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        signInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

    @RequestMapping(value = "/signup")
    public String signup(WebRequest request) {
        Connection<?> connection = signInUtils.getConnectionFromSession(request);
        if (connection != null) {
            authenticate(connection);
            signInUtils.doPostSignUp(userService.findByUserId(connection.getKey().getProviderUserId()).getUserId(), request);
        }
        return "redirect:/";
    }

    private void authenticate(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        saveToBase(userProfile, connection.getKey().getProviderUserId());
        setSecurityContext(userProfile,connection.getKey().getProviderUserId());
    }

    private void saveToBase(UserProfile userProfile, String id) {
        User user;
        if ((user = userService.findByUserId(id)) != null) {
            user.setName(userProfile.getName());
            userService.save(user);
        } else {
            user = new User();
            user.setUserId(id);
            user.setName(userProfile.getName());
            user.setRole("ROLE_USER");
            userService.save(user);
        }
    }

    private void setSecurityContext(UserProfile userProfile, String id){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user);
        if(Objects.equals(userService.findByUserId(id).getRole(), "ROLE_ADMIN"))
            authorities.add(admin);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userProfile.getName(), id, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}