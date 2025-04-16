package com.hds.sales_analytics_api_1_0.service;

import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        List<User> users=userRepository.findAll();
        if(!users.isEmpty())
            return users;
        return null;

    }

    public User updateUserRole(User userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getUser_id());

        if (user.isPresent() && !user.get().getRole().equals(userRequest.getRole())) {
            user.get().setRole(userRequest.getRole());
            userRepository.save(user.get());
            return user.get();
        } else {
            return null;
        }

    }
}
