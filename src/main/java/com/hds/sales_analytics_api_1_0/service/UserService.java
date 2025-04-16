package com.hds.sales_analytics_api_1_0.service;

import com.hds.sales_analytics_api_1_0.Model.LoginRequest;
import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private Map<String, String> roles;

    @Autowired
    private UserRepository userRepository;


    public User login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        setRoleData();
        if (user.isPresent() &&
                user.get().getFirst_name().equals(loginRequest.getPassword())) {
            User loggedUser = user.get();
            loggedUser.setRole(roles.get(loggedUser.getRole()));
            return loggedUser;
        } else {
            return null;
        }
    }

    private void setRoleData() {
        roles = new HashMap<>();
        roles.put("User", "6179");
        roles.put("Manager", "9284");
        roles.put("Admin", "4826");
    }
}
