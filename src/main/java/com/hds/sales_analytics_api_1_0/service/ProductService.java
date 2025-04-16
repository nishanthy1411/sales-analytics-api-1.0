package com.hds.sales_analytics_api_1_0.service;

import com.hds.sales_analytics_api_1_0.Model.Products;
import com.hds.sales_analytics_api_1_0.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
