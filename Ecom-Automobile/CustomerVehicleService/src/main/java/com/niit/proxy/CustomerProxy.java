package com.niit.proxy;

import com.niit.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="User-Authenticaton-Service",url = "localhost:8082")
public interface CustomerProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity saveCustomerInAuthService(@RequestBody Customer customer);
}
