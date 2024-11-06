package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.StreetFighterBike;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StreetFighterBikeRepository extends CrudRepository<StreetFighterBike, Long> {

    @Transactional
    @Modifying
    @Query("update StreetFighterBike e set e.topSpeed = ?1 where e.id = ?2")
    void update(int topSpeed, Long id );
}
