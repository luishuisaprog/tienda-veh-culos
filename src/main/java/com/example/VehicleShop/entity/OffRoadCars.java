package com.example.VehicleShop.entity;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OffRoadCars extends Cars{

    private int height;

    private String tractionType;

    public OffRoadCars(String brand, String model, String fuelType, String productionYear, int price, int height, String tractionType) {
        super(brand, model, fuelType, productionYear, price);
        this.height = height;
        this.tractionType = tractionType;
    }
}
