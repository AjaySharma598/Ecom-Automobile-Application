/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Customer {

    private String name;
    private String mobileNumber;
    @Id
    private String emailId;
    private String password;
    //private Vehicle vehicle;
    private List<Vehicle> vehicleList;
}
