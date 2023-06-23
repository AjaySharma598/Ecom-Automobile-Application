package com.niit.service;

import com.niit.domain.Customer;
import com.niit.domain.Vehicle;

import java.util.List;

public interface CustomerService {
    public List<Customer> getALLCustomers();
    public Customer addCustomer(Customer customer);
    public Customer VehicleDetails(String emailId,Vehicle vehicle);
    public Customer getCustomerById(String emailId);
    public List<Vehicle> getOrderVehicleDetails(String emailId);
    public boolean removeItem(String email,String vehicleId);


}
