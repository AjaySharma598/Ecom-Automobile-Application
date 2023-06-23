package com.niit.service;

import com.niit.domain.Customer;

import java.util.Map;

public interface SecurityGeneratorToken {
    public Map<String,String> generateToken(Customer customer);
}
