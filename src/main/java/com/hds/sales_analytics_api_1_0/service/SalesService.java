package com.hds.sales_analytics_api_1_0.service;

import java.util.List;
import java.util.Optional;

import com.hds.sales_analytics_api_1_0.Model.Sales;
import com.hds.sales_analytics_api_1_0.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.Repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

	public List<Sales> getSalesFromRegion(Sales region){
		Optional<List<Sales>> sales = salesRepository.findByRegion(region.getRegion());
		return sales.orElse(null);
	}

	public List<Sales> getAllSales() {
		return salesRepository.findAll();
	}

}
