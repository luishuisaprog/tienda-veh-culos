package com.example.VehicleShop.service;

import com.example.VehicleShop.entity.*;
import com.example.VehicleShop.objects.*;
import com.example.VehicleShop.repository.*;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.util.List;

@Service
public class MigrationService {


    @Autowired
    private LuxuryCarRepository luxuryCarRepository;

    @Autowired
    private OffRoadCarsRepository offRoadCarsRepository;

    @Autowired
    private SportsCarRepository sportsCarRepository;

    @Autowired
    private StreetFighterBikeRepository streetFighterBikeRepository;

    @Autowired
    private TourerRepository tourerRepository;



    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void migrateFromCSVtoDB() {

        String fileName = "src/main/resources/LuxuryCar.csv";
        List<LuxuryCarCSVObject> luxuryCarCSVObjects;

        try {
            luxuryCarCSVObjects = new CsvToBeanBuilder<LuxuryCarCSVObject>(new FileReader(fileName))
                    .withType(LuxuryCarCSVObject.class)
                    .build()
                    .parse();
            System.out.println(luxuryCarCSVObjects);
            luxuryCarCSVObjects
                    .forEach(l -> luxuryCarRepository.save(new LuxuryCar(l.getBrand(),l.getModel(),l.getFuelType(),l.getProductionYear()
                    , l.getPrice(),l.getFeatures(), l.getMassageSeats())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileName1 = "src/main/resources/OffRoadCars.csv";
        List<OffRoadCarsCSVObject> offRoadCarsCSVObjects;

        try {
            offRoadCarsCSVObjects = new CsvToBeanBuilder<OffRoadCarsCSVObject>(new FileReader(fileName1))
                    .withType(OffRoadCarsCSVObject.class)
                    .build()
                    .parse();
            System.out.println(offRoadCarsCSVObjects);
            offRoadCarsCSVObjects
                    .forEach(l -> offRoadCarsRepository.save(new OffRoadCars(l.getBrand(),l.getModel(),l.getFuelType(),l.getProductionYear()
                            , l.getPrice(),l.getHeight(), l.getTractionType())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileName2 = "src/main/resources/SportsCar.csv";
        List<SportsCarCSVObject> sportsCarCSVObjects;

        try {
            sportsCarCSVObjects = new CsvToBeanBuilder<SportsCarCSVObject>(new FileReader(fileName2))
                    .withType(SportsCarCSVObject.class)
                    .build()
                    .parse();
            System.out.println(sportsCarCSVObjects);
            sportsCarCSVObjects
                    .forEach(l -> sportsCarRepository.save(new SportsCar(l.getBrand(),l.getModel(),l.getFuelType(),l.getProductionYear()
                            , l.getPrice(),l.getTopSpeed(),l.getBodyType(),l.getExhaustType(),l.getDragRaceTime())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileName3 = "src/main/resources/StreetFighterBike.csv";
        List<StreetFighterBikeCSVObject> streetFighterBikeCSVObjects;

        try {
            streetFighterBikeCSVObjects = new CsvToBeanBuilder<StreetFighterBikeCSVObject>(new FileReader(fileName3))
                    .withType(StreetFighterBikeCSVObject.class)
                    .build()
                    .parse();
            System.out.println(streetFighterBikeCSVObjects);
            streetFighterBikeCSVObjects
                    .forEach(l -> streetFighterBikeRepository.save(new StreetFighterBike(l.getBrand(),l.getModel(),
                            l.getEngineDisplacement(),l.getTopSpeed())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileName4 = "src/main/resources/TourerBike.csv";
        List<TourerBikeCSVObject> tourerBikeCSVObjects;

        try {
            tourerBikeCSVObjects = new CsvToBeanBuilder<TourerBikeCSVObject>(new FileReader(fileName4))
                    .withType(TourerBikeCSVObject.class)
                    .build()
                    .parse();
            System.out.println(tourerBikeCSVObjects);
            tourerBikeCSVObjects
                    .forEach(l -> tourerRepository.save(new TourerBike(l.getBrand(),l.getModel(),l.getEngineDisplacement(),
                    l.getTankCapacity())));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
