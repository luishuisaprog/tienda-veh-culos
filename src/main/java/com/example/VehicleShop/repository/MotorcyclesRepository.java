package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.Motorcycles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcyclesRepository extends CrudRepository<Motorcycles,Long> {
}
