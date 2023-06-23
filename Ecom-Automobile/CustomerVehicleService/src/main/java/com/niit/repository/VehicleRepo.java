package com.niit.repository;

import com.niit.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends MongoRepository<Vehicle,String> {

}
