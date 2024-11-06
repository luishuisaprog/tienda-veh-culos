package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.SportsCar;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SportsCarRepository extends CrudRepository<SportsCar,Long> {
    @Transactional
    @Modifying
    @Query("update SportsCar s set s.dragRaceTime = ?1 where s.id = ?2")
    void update(int dragRaceTime, Long id );
}
