package com.example.VehicleShop.entity;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TourerBike extends Motorcycles{

    private Integer tankCapacity;

    public TourerBike(String brand, String model, int engineDisplacement, Integer tankCapacity) {
        super(brand, model, engineDisplacement);
        this.tankCapacity = tankCapacity;
    }
}
