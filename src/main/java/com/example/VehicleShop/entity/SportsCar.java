package com.example.VehicleShop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SportsCar extends Cars{

    private int topSpeed;

    private String bodyType;

    private String exhaustType;


    private int dragRaceTime;



    public SportsCar(String brand, String model, String fuelType, String productionYear,
                     int price, int topSpeed, String bodyType,
                     String exhaustType, int dragRaceTime) {
        super(brand, model, fuelType, productionYear, price);
        this.topSpeed = topSpeed;
        this.bodyType = bodyType;
        this.exhaustType = exhaustType;
        this.dragRaceTime = dragRaceTime;
    }
}
