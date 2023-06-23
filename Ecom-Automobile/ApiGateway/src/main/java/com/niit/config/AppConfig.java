/*
 * Author:Ajay Sharma
 * Date : 13-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                       // .uri("http://localhost:8082/"))
                          // use the name of the application in the uri
                        .uri("lb://User-Authenticaton-Service"))
                .route(p->p
                        .path("/api/v2/**")
                        //.uri("http://localhost:8083/"))
                        .uri("lb://User-vehicle-Service"))
                .build();
    }
}
