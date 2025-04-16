package com.hds.sales_analytics_api_1_0.Controller;

import com.hds.sales_analytics_api_1_0.Model.Sales;
import com.hds.sales_analytics_api_1_0.Repository.SalesRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @PostMapping("/sales")
    public ResponseEntity<List<Sales>> getSalesFromRegion(@RequestBody Sales region){
        Optional<List<Sales>> sales = salesRepository.findByRegion(region.getRegion());
        return sales.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/sales/all")
    public ResponseEntity<List<Sales>> getAllSales() {
        return ResponseEntity.ok(salesRepository.findAll());
    }
}
