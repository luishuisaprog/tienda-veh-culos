package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.TourerBike;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TourerRepository extends CrudRepository<TourerBike,Long> {

    @Transactional
    @Modifying
    @Query("update TourerBike t set t.tankCapacity = ?1 where t.id = ?2")
    void update(int tankCapacity, Long id );
}
