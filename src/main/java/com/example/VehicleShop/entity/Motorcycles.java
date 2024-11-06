package com.example.VehicleShop.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Motorcycles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String brand;

    protected String model;

    protected int engineDisplacement;

    public Motorcycles(String brand, String model, int engineDisplacement) {
        this.brand = brand;
        this.model = model;
        this.engineDisplacement = engineDisplacement;
    }
}
