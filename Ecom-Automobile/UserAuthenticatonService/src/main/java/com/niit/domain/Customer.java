/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    private String emailId;
    private String password;
}
