package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerNotFoundException;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public Customer findByEmailIdAndPassword(String emailId,String Password) throws CustomerNotFoundException;
}
