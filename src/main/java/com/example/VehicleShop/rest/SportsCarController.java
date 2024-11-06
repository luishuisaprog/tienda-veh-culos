package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.SportsCar;
import com.example.VehicleShop.entity.SportsCar;
import com.example.VehicleShop.repository.OffRoadCarsRepository;
import com.example.VehicleShop.repository.SportsCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SportsCarController {
    @Autowired
    SportsCarRepository sportsCarRepository;


    @GetMapping("/get-sportscars")
    public ResponseEntity<Iterable<SportsCar>> getSportsCars() {
        return new ResponseEntity<>(sportsCarRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-sportscar")
    public ResponseEntity<SportsCar> addSportsCar(@RequestBody SportsCar sportsCar) {
        try {
            return new ResponseEntity<>(sportsCarRepository.save(sportsCar), HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-sportscar/{id}")
    public ResponseEntity<SportsCar> getSportsCarById(@PathVariable Long id) {
        final Optional<SportsCar> optionalSportsCar = sportsCarRepository.findById(id);
        return optionalSportsCar.map(sportsCar -> new ResponseEntity<>(sportsCar, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete-sportscar/{id}")
    public ResponseEntity<Void> deleteSportsCar(@PathVariable Long id){
        sportsCarRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update-sportscar/{id}")
    public ResponseEntity<Void> updateSportsCar(@PathVariable Long id, @RequestBody SportsCar sportsCar){
        sportsCarRepository.update(sportsCar.getDragRaceTime(), id);
        return ResponseEntity.ok().build();
    }
}
