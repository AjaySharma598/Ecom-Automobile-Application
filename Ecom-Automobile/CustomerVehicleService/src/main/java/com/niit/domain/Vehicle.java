/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Vehicle {
    @Id
    private String vehicleId;
    private String vehicleName;

    private String vehiclePrice;
    private String vehicleImageUrl;
}
