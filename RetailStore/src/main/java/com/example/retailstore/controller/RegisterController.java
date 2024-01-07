package com.example.retailstore.controller;


import com.example.retailstore.model.Customer;
import com.example.retailstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
        ResponseEntity<String> response = null;
        try{
            Customer savedCustomer = customerService.createCustomer(customer);
            if(savedCustomer.getId() >0){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Customer is created successfully for user for customer =" + customer.getUsername());
            }
        }catch (Exception exception){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from sever with exception=" + exception);
        }
        return response;
    }
}
