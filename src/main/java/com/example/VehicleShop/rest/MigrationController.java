package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.LuxuryCar;
import com.example.VehicleShop.entity.OffRoadCars;
import com.example.VehicleShop.repository.*;
import com.example.VehicleShop.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MigrationController {

    @Autowired
    MigrationService migrationService;

    @Autowired
    LuxuryCarRepository luxuryCarRepository;

    @Autowired
    OffRoadCarsRepository offRoadCarsRepository;

    @Autowired
    SportsCarRepository sportsCarRepository;

    @Autowired
    StreetFighterBikeRepository streetFighterBikeRepository;

    @Autowired
    TourerRepository tourerRepository;


    @PostMapping(value = "/migrate")
    public void migrate() {
        migrationService.migrateFromCSVtoDB();
    }

    @GetMapping
    public Iterable<LuxuryCar> getAllLocations() {
        return luxuryCarRepository.findAll();
    }
}
