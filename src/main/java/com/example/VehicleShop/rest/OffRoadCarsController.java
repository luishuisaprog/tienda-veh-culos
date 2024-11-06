package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.OffRoadCars;
import com.example.VehicleShop.entity.OffRoadCars;
import com.example.VehicleShop.repository.LuxuryCarRepository;
import com.example.VehicleShop.repository.OffRoadCarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OffRoadCarsController {
    @Autowired
    OffRoadCarsRepository offRoadCarsRepository;

    @GetMapping("/get-offroadcars")
    public ResponseEntity<Iterable<OffRoadCars>> getOffRoadCars() {
        return new ResponseEntity<>(offRoadCarsRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-offroadcar")
    public ResponseEntity<OffRoadCars> addOffRoadCar(@RequestBody OffRoadCars offRoadCar) {
        try {
            return new ResponseEntity<>(offRoadCarsRepository.save(offRoadCar), HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-offroadcar/{id}")
    public ResponseEntity<OffRoadCars> getOffRoadCarById(@PathVariable Long id) {
        final Optional<OffRoadCars> optionalOffRoadCar = offRoadCarsRepository.findById(id);
        return optionalOffRoadCar.map(offRoadCars -> new ResponseEntity<>(offRoadCars, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete-offroadcar/{id}")
    public ResponseEntity<Void> deleteOffRoadCar(@PathVariable Long id){
        offRoadCarsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update-offroadcar/{id}")
    public ResponseEntity<Void> updateOffRoadCar(@PathVariable Long id, @RequestBody OffRoadCars offRoadCars){
        offRoadCarsRepository.update(offRoadCars.getTractionType(), id);
        return ResponseEntity.ok().build();
    }

}
