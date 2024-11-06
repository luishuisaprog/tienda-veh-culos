package com.example.VehicleShop.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LuxuryCar extends Cars{

    private String features;

    private String massageSeats;


    public LuxuryCar(String brand, String model, String fuelType, String productionYear,
                     int price, String features, String massageSeats) {
        super(brand, model, fuelType, productionYear, price);
        this.features=features;
        this.massageSeats=massageSeats;
    }
}
