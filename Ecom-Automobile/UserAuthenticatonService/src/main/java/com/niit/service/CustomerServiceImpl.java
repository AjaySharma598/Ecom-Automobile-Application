/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerNotFoundException;
import com.niit.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    @Override
    public Customer findByEmailIdAndPassword(String emailId, String Password) throws CustomerNotFoundException {
        Customer customer = customerRepo.findByEmailIdAndPassword(emailId, Password);
  if(customer.getEmailId().equals(emailId)&&customer.getPassword().equals(Password)){

      System.out.println(customer);
      return customer;
    }
      throw new CustomerNotFoundException();
    }
}
