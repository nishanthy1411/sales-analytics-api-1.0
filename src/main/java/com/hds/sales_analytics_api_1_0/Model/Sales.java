package com.hds.sales_analytics_api_1_0.Model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Sales {
	
	@Id
    private Long sale_id;
    private String product_name;
    private String region;
    private Double sale_amount;
    private LocalDate sale_date;

    public Long getSale_id() {
        return sale_id;
    }

    public void setSale_id(Long sale_id) {
        this.sale_id = sale_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(Double sale_amount) {
        this.sale_amount = sale_amount;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }
}
