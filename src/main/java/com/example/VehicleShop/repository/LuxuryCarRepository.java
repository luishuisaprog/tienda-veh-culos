package com.example.VehicleShop.repository;

import com.example.VehicleShop.entity.LuxuryCar;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LuxuryCarRepository extends CrudRepository<LuxuryCar,Long> {

    @Transactional
    @Modifying
    @Query("update LuxuryCar l set l.features = ?1 where l.id = ?2")
    void update(String features, Long id );
}
