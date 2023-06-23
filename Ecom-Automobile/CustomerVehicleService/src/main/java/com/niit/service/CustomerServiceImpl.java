/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.service;


import com.niit.domain.Customer;
import com.niit.domain.Vehicle;
import com.niit.proxy.CustomerProxy;
import com.niit.repository.CustomerRepo;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerProxy customerProxy;
    @Override
    public List<Customer> getALLCustomers() {

        return customerRepo.findAll();
    }
    @Override
    public Customer addCustomer(Customer customer) {
        if(!customer.getEmailId().isEmpty()){
            customerProxy.saveCustomerInAuthService(customer);
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer VehicleDetails(String emailId, Vehicle vehicle) {
        Customer customer = customerRepo.findById(emailId).get();
        if(customer.getVehicleList()==null){
            customer.setVehicleList(Arrays.asList(vehicle));
        }else {
            customer.getVehicleList().add(vehicle);
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(String emailId) {
        return customerRepo.findById(emailId).get();
    }

    @Override
    public List<Vehicle> getOrderVehicleDetails(String emailId) {
        if(customerRepo.findById(emailId).isPresent()){
           List<Vehicle> vehicleList=customerRepo.findById(emailId).get().getVehicleList();
           return vehicleList;
        }
        return null;
    }

    @Override
    public boolean removeItem(String email, String vehicleId) {
        Customer customer = customerRepo.findById(email).get();
        if(customer!=null){
     Vehicle vehicle=customer.getVehicleList().stream().filter(p->p.getVehicleId().equals(vehicleId)).findFirst().orElse(null);
         if(vehicle!=null){
             customer.getVehicleList().remove(vehicle);
             customerRepo.save(customer);
             return true;
         }
        }
        return false;
    }
}