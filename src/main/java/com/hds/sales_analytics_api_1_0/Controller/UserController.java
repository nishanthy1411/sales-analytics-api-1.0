package com.hds.sales_analytics_api_1_0.Controller;

import com.hds.sales_analytics_api_1_0.Model.LoginRequest;
import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private Map<String, Integer> roles;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        setRoleData();
        if (user.isPresent() &&
                user.get().getFirst_name().equals(loginRequest.getPassword())) {
            User loggedUser = user.get();
            loggedUser.setRole(roles.get(loggedUser.getRole()).toString());
            return ResponseEntity.ok(loggedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    private void setRoleData() {
        roles = new HashMap<>();
        roles.put("User", 6179);
        roles.put("Manager", 9284);
        roles.put("Admin", 4826);
    }
}

