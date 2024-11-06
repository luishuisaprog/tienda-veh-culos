package com.example.VehicleShop.entity;


import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class StreetFighterBike extends Motorcycles{

    private int topSpeed;

    public StreetFighterBike(String brand, String model, int engineDisplacement, int topSpeed) {
        super(brand, model, engineDisplacement);
        this.topSpeed = topSpeed;
    }
}
