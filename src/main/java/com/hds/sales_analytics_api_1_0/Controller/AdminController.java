package com.hds.sales_analytics_api_1_0.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/admin")
	public ResponseEntity<List<User>> findAll(){
		List<User> users=userRepository.findAll();
		if(!users.isEmpty())
			return ResponseEntity.ok(users);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		
	}
	
	@PutMapping("/admin/updaterole")
	public ResponseEntity<User> updateUserRole(@RequestBody User userRequest) {
		Optional<User> user = userRepository.findById(userRequest.getUser_id());
		
		if (user.isPresent() && !user.get().getRole().equals(userRequest.getRole())) {
			user.get().setRole(userRequest.getRole());
			userRepository.save(user.get());
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		
	}
}
