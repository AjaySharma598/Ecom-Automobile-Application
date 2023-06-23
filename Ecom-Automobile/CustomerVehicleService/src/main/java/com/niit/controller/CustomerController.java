/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.controller;

import com.niit.domain.Customer;
import com.niit.domain.Vehicle;
import com.niit.service.CustomerService;
import com.niit.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class CustomerController {
    CustomerService customerService;
    VehicleService vehicleService;
    @Autowired
    public CustomerController(CustomerService customerService, VehicleService productService) {
        this.customerService = customerService;
        this.vehicleService = productService;
    }
    @PostMapping("/customer")
    public ResponseEntity<?> saveRegister( @RequestBody Customer customer){
        Customer customer1 = customerService.addCustomer(customer);
        if(customer1!=null){
            return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/allUsers/customers")
    public ResponseEntity<?>  getAllCustomer(){
        List<Customer> allCustomers = customerService.getALLCustomers();
        if(allCustomers.size()>0){
            return new ResponseEntity <List<Customer>>(allCustomers,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct( @RequestBody Vehicle product){
        Vehicle product1 = vehicleService.addProduct(product);
        if(product1!=null){
            return new ResponseEntity<Vehicle>(product1, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/allUsers/products")
    public ResponseEntity<?>  getAllProduct(){
        List<Vehicle> allProducts = vehicleService.getAllProducts();
        if(allProducts.size()>0){
            return new ResponseEntity <List<Vehicle>>(allProducts,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allUsers/productBy/{vehicleId}")
    public ResponseEntity<?> getProductById(@PathVariable String vehicleId ){
        Vehicle vehicleById = vehicleService.getVehicleById(vehicleId);
        if (vehicleById!=null){
            return new ResponseEntity<Vehicle>(vehicleById,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/allUsers/productCart/{emailId}")
    public ResponseEntity<?> addCart(@PathVariable String emailId, @RequestBody Vehicle vehicle){
        Customer vehicle1 = customerService.VehicleDetails(emailId,vehicle);
        if(vehicle1!=null){
            return new ResponseEntity(vehicle1, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/allUsers/customer/{emailId}")
    public ResponseEntity<?> getCustomerByUserId(@PathVariable String emailId) {

        return new ResponseEntity<>(customerService.getCustomerById(emailId), HttpStatus.OK);
    }

    @GetMapping("/allUsers/cart/{emailId}")
    public ResponseEntity<?> getCartVehicleList(@PathVariable String emailId) {
        List<Vehicle> orderVehicleDetails = customerService.getOrderVehicleDetails(emailId);
        if(orderVehicleDetails.size()>0){
            return new ResponseEntity<>(orderVehicleDetails,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error occurred",HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/allUsers/itemDelete/{emailId}/{vehicleId}")
    public ResponseEntity<?> deleteItemById(@PathVariable String emailId,@PathVariable String vehicleId){
        boolean result = customerService.removeItem(emailId,vehicleId);
        if(result){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
}
