/*
 * Author:Ajay Sharma
 * Date : 10-02-2023
 *Created With : Intellij IDEA Community Edition
 */

package com.niit.service;

import com.niit.domain.Customer;
import com.niit.domain.Vehicle;
import com.niit.repository.CustomerRepo;
import com.niit.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepo vehicleRepo;
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Vehicle> getAllProducts() {

        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle getVehicleById(String vehicleId) {
        return vehicleRepo.findById(vehicleId).get();
    }

    @Override
    public Vehicle addProduct(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public boolean deleteProduct(String id) {
        if (vehicleRepo.findById(id).isPresent()) {
            vehicleRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Vehicle searchVehicle(String vehicleId) {
        return vehicleRepo.findById(vehicleId).get();
    }


}
