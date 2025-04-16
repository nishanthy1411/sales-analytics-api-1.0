package com.hds.sales_analytics_api_1_0.Controller;

import com.hds.sales_analytics_api_1_0.Model.LoginRequest;
import com.hds.sales_analytics_api_1_0.Model.Products;
import com.hds.sales_analytics_api_1_0.Model.Sales;
import com.hds.sales_analytics_api_1_0.Model.User;
import com.hds.sales_analytics_api_1_0.service.AdminService;
import com.hds.sales_analytics_api_1_0.service.ProductService;
import com.hds.sales_analytics_api_1_0.service.SalesService;
import com.hds.sales_analytics_api_1_0.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class ApiController {
    private final SalesService salesService;
    private final UserService userService;
    private final AdminService adminService;
    private final ProductService productService;

    public ApiController(SalesService salesService, UserService userService, AdminService adminService, ProductService productService) {
        this.salesService = salesService;
        this.userService = userService;
        this.adminService = adminService;
        this.productService = productService;
    }

    @PostMapping("/sales")
    public ResponseEntity<List<Sales>> getSalesFromRegion(@RequestBody Sales region){
        List<Sales> sales = salesService.getSalesFromRegion(region);
        if (sales == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/sales/all")
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        if (sales == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(salesService.getAllSales());
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user =userService.login(loginRequest);
        if (user != null){
           return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = adminService.findAll();
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping("/admin/updaterole")
    public ResponseEntity<User> updateUserRole(@RequestBody User userRequest) {
        User user = adminService.updateUserRole(userRequest);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(products);
    }
}
