package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.OffRoadCars;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OffRoadCarsRepository extends CrudRepository<OffRoadCars,Long> {

    @Transactional
    @Modifying
    @Query("update OffRoadCars o set o.tractionType = ?1 where o.id = ?2")
    void update(String tractionType, Long id );
}
