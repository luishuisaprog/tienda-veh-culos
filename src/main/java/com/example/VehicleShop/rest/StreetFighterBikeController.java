package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.StreetFighterBike;
import com.example.VehicleShop.repository.SportsCarRepository;
import com.example.VehicleShop.repository.StreetFighterBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StreetFighterBikeController {

    @Autowired
    StreetFighterBikeRepository streetFighterBikeRepository;

    @GetMapping("/get-sfbike")
    public ResponseEntity<Iterable<StreetFighterBike>> getSFBike() {
        return new ResponseEntity<>(streetFighterBikeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-sfbike")
    public ResponseEntity<StreetFighterBike> addSFBike(@RequestBody StreetFighterBike streetFighterBike) {
        try {
            return new ResponseEntity<>(streetFighterBikeRepository.save(streetFighterBike), HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-sfbike/{id}")
    public ResponseEntity<StreetFighterBike> getSFBikeById(@PathVariable Long id) {
        final Optional<StreetFighterBike> optionalStreetFighterBike = streetFighterBikeRepository.findById(id);
        return optionalStreetFighterBike.map(streetFighterBike -> new ResponseEntity<>(streetFighterBike, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete-sfbike/{id}")
    public ResponseEntity<Void> deleteSFBike(@PathVariable Long id){
        streetFighterBikeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update-sfbike/{id}")
    public ResponseEntity<Void> updateSFBike(@PathVariable Long id, @RequestBody StreetFighterBike streetFighterBike){
        streetFighterBikeRepository.update(streetFighterBike.getTopSpeed(), id);
        return ResponseEntity.ok().build();
    }
}
