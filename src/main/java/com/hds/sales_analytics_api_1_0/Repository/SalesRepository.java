package com.hds.sales_analytics_api_1_0.Repository;

import com.hds.sales_analytics_api_1_0.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    Optional<List<Sales>> findByRegion(String region);
}
