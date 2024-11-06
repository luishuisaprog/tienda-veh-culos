package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.LuxuryCar;
import com.example.VehicleShop.repository.LuxuryCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LuxuryCarController {
    @Autowired
    LuxuryCarRepository luxuryCarRepository;

    @GetMapping("/get-luxurycars")
    public ResponseEntity<Iterable<LuxuryCar>> getAllLuxuryCars() {
        return new ResponseEntity<>(luxuryCarRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-luxurycar")
    public ResponseEntity<LuxuryCar> addLuxuryCar(@RequestBody LuxuryCar luxuryCar) {
        try {
            return new ResponseEntity<>(luxuryCarRepository.save(luxuryCar), HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-luxurycar/{id}")
    public ResponseEntity<LuxuryCar> getLuxuryCarById(@PathVariable Long id) {
        final Optional<LuxuryCar> optionalLuxuryCar = luxuryCarRepository.findById(id);
        return optionalLuxuryCar.map(luxuryCar -> new ResponseEntity<>(luxuryCar, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete-luxurycar/{id}")
    public ResponseEntity<Void> deleteLuxuryCar(@PathVariable Long id){
        luxuryCarRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update-luxurycar/{id}")
    public ResponseEntity<Void> updateLuxuryCar(@PathVariable Long id, @RequestBody LuxuryCar luxuryCar){
        luxuryCarRepository.update(luxuryCar.getFeatures(), id);
        return ResponseEntity.ok().build();
    }

}
