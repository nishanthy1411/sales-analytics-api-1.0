package com.hds.sales_analytics_api_1_0.Repository;

import com.hds.sales_analytics_api_1_0.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findByProductName(String name);
}
