package com.hds.sales_analytics_api_1_0.Model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Sales {
	
	@Id
    private Long saleId;
    private String productName;
    private String region;
    private Double saleAmount;
    private LocalDate date;
    

}
