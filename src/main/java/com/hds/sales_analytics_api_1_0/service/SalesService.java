package com.hds.sales_analytics_api_1_0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;

@Service
public class SalesService {

	@Autowired
	private UserRepository repository;
	
	public List<User> fetchUsers(String region, String role) {

		return repository.findByRegionAndRole(region, role);
	}

}
