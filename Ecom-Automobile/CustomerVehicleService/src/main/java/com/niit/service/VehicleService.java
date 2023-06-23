package com.niit.service;

import com.niit.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllProducts();
    public Vehicle getVehicleById(String vehicleId);
    public Vehicle addProduct(Vehicle product);
    public boolean deleteProduct(String id);
    public Vehicle searchVehicle(String vehicleId);

}
