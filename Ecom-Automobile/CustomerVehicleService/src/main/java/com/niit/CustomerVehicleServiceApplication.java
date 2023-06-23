package com.niit;

import com.niit.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerVehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerVehicleServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterUrl() {
		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/allUsers/*");
		return registrationBean;
	}


}
