/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.controller;

import com.niit.domain.Customer;
import com.niit.exception.CustomerNotFoundException;
import com.niit.service.CustomerService;
import com.niit.service.SecurityGeneratorTokenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    CustomerService customerService;
    SecurityGeneratorTokenImpl securityGeneratorToken;
   @Autowired

    public CustomerController(CustomerService customerService, SecurityGeneratorTokenImpl securityGeneratorToken) {
        this.customerService = customerService;
        this.securityGeneratorToken = securityGeneratorToken;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.saveCustomer(customer);
        if(customer1!=null){
            return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>("Error Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<?> loginCheck(@RequestBody Customer customer) throws CustomerNotFoundException {
        Customer login = customerService.findByEmailIdAndPassword(customer.getEmailId(), customer.getPassword());
        System.out.println(login);
        if(login!=null){
            return new ResponseEntity<>(securityGeneratorToken.generateToken(login), HttpStatus.OK);
        }else{
            throw new CustomerNotFoundException();
        }
    }
}
