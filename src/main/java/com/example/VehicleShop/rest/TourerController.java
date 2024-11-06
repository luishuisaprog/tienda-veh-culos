package com.example.VehicleShop.rest;

import com.example.VehicleShop.entity.TourerBike;
import com.example.VehicleShop.repository.TourerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TourerController {

    @Autowired
    TourerRepository tourerRepository;


    @GetMapping("/get-tourerbike")
    public ResponseEntity<Iterable<TourerBike>> getTourerBike() {
        return new ResponseEntity<>(tourerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-tourerbike")
    public ResponseEntity<TourerBike> addTourerBike(@RequestBody TourerBike tourerBike) {
        try {
            return new ResponseEntity<>(tourerRepository.save(tourerBike), HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-tourerbike/{id}")
    public ResponseEntity<TourerBike> getTourerBikeById(@PathVariable Long id) {
        final Optional<TourerBike> optionalTourerBike = tourerRepository.findById(id);
        return optionalTourerBike.map(tourerBike -> new ResponseEntity<>(tourerBike, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete-tourerbike/{id}")
    public ResponseEntity<Void> deleteTourerBike(@PathVariable Long id){
        tourerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update-tourerbike/{id}")
    public ResponseEntity<Void> updateTourerBike(@PathVariable Long id, @RequestBody TourerBike tourerBike){
        tourerRepository.update(tourerBike.getTankCapacity(), id);
        return ResponseEntity.ok().build();
    }
}
